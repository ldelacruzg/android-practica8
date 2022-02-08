package app.smty.practica8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import app.smty.practica8.Models.RequestForPayment;
import app.smty.practica8.Models.ResponseSale;
import app.smty.practica8.Models.ResponseSaleClient;
import app.smty.practica8.Services.PayPhoneService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editTextPhoneNumber, editTextClientUserId, editTextAmount, editTextCountryCode;
    private Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    public void initUI() {
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextClientUserId = findViewById(R.id.editTextClientUserId);
        editTextAmount = findViewById(R.id.editTextAmount);
        editTextCountryCode = findViewById(R.id.editTextCountryCode);
    }

    public void generateRequestForPyment(View view) {
        if (validateForm()) {
            RequestForPayment requestForPayment = new RequestForPayment(
                    editTextPhoneNumber.getText().toString(),
                    editTextCountryCode.getText().toString(),
                    editTextClientUserId.getText().toString(),
                    Integer.parseInt(editTextAmount.getText().toString())
            );

            PayPhoneService payPhoneService = getClient("https://pay.payphonetodoesposible.com/api/")
                    .create(PayPhoneService.class);

            Call<ResponseSale> responseSaleCall = payPhoneService.generateRequestForPayment(requestForPayment);
            responseSaleCall.enqueue(new Callback<ResponseSale>() {
                @Override
                public void onResponse(Call<ResponseSale> call, Response<ResponseSale> response) {
                    ResponseSale body = response.body();
                    openPayPhoneApp(body);
                }

                @Override
                public void onFailure(Call<ResponseSale> call, Throwable t) {

                }
            });

        }
    }

    private void openResponseSaleClient(int transactionId) {
        Intent intent = new Intent(MainActivity.this, ResultPaymentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("transaction", String.valueOf(transactionId));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void openPayPhoneApp(ResponseSale responseSale){
        Intent intent = new Intent("payPhone_Android.PayPhone_Android.Purchase");
        Gson gson = new Gson();
        intent.putExtra("otherApp", true);

        String parameters = gson.toJson(responseSale);
        intent.putExtra("parameters", parameters);
        intent.putExtra("package", getPackageName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }

    private Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private boolean validateForm() {
        int lenghtPhoneNumber = editTextPhoneNumber.getText().length();
        int lenghtCINumber = editTextClientUserId.getText().length();
        int lenghtAmount = editTextAmount.getText().length();
        int lenghtCountryCode = editTextCountryCode.getText().length();

        if (lenghtCountryCode < 0 && lenghtCountryCode > 4) {
            editTextCountryCode.setError(getString(R.string.txt_country_code_error));
            return false;
        } else {
            editTextCountryCode.setError(null);
        }

        if (lenghtPhoneNumber != 9 ) {
            editTextPhoneNumber.setError(getString(R.string.txt_phone_number_error));
            return false;
        } else {
            editTextPhoneNumber.setError(null);
        }

        if (lenghtCINumber != 10) {
            editTextClientUserId.setError(getString(R.string.txt_ci_number_error));
            return false;
        } else {
            editTextClientUserId.setError(null);
        }

        if (lenghtAmount == 0 || editTextAmount.getText().equals("")) {
            editTextAmount.setError(getString(R.string.txt_amount_error));
            return false;
        } else {
            editTextAmount.setError(null);
        }

        return true;
    }

    public void viewTransaction(View view) {
        Intent intent = new Intent(this, ResultPaymentActivity.class);
        startActivity(intent);
    }
}