package app.smty.practica8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import app.smty.practica8.Models.ResponseSaleClient;
import app.smty.practica8.Services.PayPhoneService;
import app.smty.practica8.Services.RetrofitLib;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultPaymentActivity extends AppCompatActivity {
    TextView textViewEmail, textViewClientTransactionId,
            textViewPhoneNumber2, textViewTransactionStatus, textViewDocument, textViewAmount2;

    EditText editTextTransactionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_payment);

        initUI();

        Bundle bundle = getIntent().getExtras();

        String transactionId = "";

        if (bundle != null) {
            transactionId = bundle.getString("transaction");
        }

        if (!transactionId.isEmpty()) {
            editTextTransactionId.setText(transactionId);
            getPaymentDetails(Integer.parseInt(transactionId));
        }
    }

    public void initUI() {
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewClientTransactionId = findViewById(R.id.textViewClientTransactionId);
        textViewPhoneNumber2 = findViewById(R.id.textViewPhoneNumber2);
        textViewTransactionStatus = findViewById(R.id.textViewTransactionStatus);
        textViewDocument = findViewById(R.id.textViewDocument);
        textViewAmount2 = findViewById(R.id.textViewAmount2);
        editTextTransactionId = findViewById(R.id.editTextTransactionId);
    }

    private void getPaymentDetails(int transationId) {
        PayPhoneService payPhoneService = RetrofitLib.getClient("https://pay.payphonetodoesposible.com/api/")
                .create(PayPhoneService.class);

        payPhoneService.showRequestForPayment(transationId).enqueue(new Callback<ResponseSaleClient>() {
            @Override
            public void onResponse(Call<ResponseSaleClient> call, Response<ResponseSaleClient> response) {
                ResponseSaleClient responseSaleClient = response.body();
                textViewEmail.setText("Email: " + responseSaleClient.getEmail());
                textViewClientTransactionId.setText("# Transacción: " +responseSaleClient.getClientTransactionId());
                textViewPhoneNumber2.setText("# Teléfono: " +responseSaleClient.getPhoneNumber());
                textViewTransactionStatus.setText("Status: " +responseSaleClient.getTransactionStatus());
                textViewDocument.setText("# Cédula: " +responseSaleClient.getDocument());
                textViewAmount2.setText("Monto: " + String.valueOf(responseSaleClient.getAmount() / 100) + "$");
            }

            @Override
            public void onFailure(Call<ResponseSaleClient> call, Throwable t) {

            }
        });
    }

    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void updateTransactionDetails(View view) {
        getPaymentDetails(Integer.parseInt(editTextTransactionId.getText().toString()));
    }
}