package app.smty.practica8.Services;

import app.smty.practica8.Models.RequestForPayment;
import app.smty.practica8.Models.ResponseSale;
import app.smty.practica8.Models.ResponseSaleClient;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PayPhoneService {
    @POST("Sale")
    @Headers("Authorization: Bearer 6pc3RGukDpzunmEtmJJBNXw8A7N6_xh0TCIDVe-LCEda0OEynYRtTLLxVGCmWdA7gzAw0jD9izOQe89UKbLsH935khJEOh7Tus7-OGYVy9mcUdJPUKwyBu7MyIMqysDOWe_oMG6YNL0J2CM_o9UFzEigSX3qkIaV84sLM5b4DUD0-3GMnfGbFjvVAtETKbPBsX_mwpOtX-32kvf4SOAes2NzWTSc-ju2fu2bgODAvh0W686FC6h2L3dqBrn7eaTaXhdbsPTwp7DUUCQlZ30qFHSURSrtphJqqKtO5QQpZxZs04RPEqLp65rlryhMgR6g2s2rMnUEaxC5O_j9DefVbfsDZ0E")
    Call<ResponseSale> generateRequestForPayment(@Body RequestForPayment requestForPayment);

    @GET("Sale/{id}")
    @Headers("Authorization: Bearer 6pc3RGukDpzunmEtmJJBNXw8A7N6_xh0TCIDVe-LCEda0OEynYRtTLLxVGCmWdA7gzAw0jD9izOQe89UKbLsH935khJEOh7Tus7-OGYVy9mcUdJPUKwyBu7MyIMqysDOWe_oMG6YNL0J2CM_o9UFzEigSX3qkIaV84sLM5b4DUD0-3GMnfGbFjvVAtETKbPBsX_mwpOtX-32kvf4SOAes2NzWTSc-ju2fu2bgODAvh0W686FC6h2L3dqBrn7eaTaXhdbsPTwp7DUUCQlZ30qFHSURSrtphJqqKtO5QQpZxZs04RPEqLp65rlryhMgR6g2s2rMnUEaxC5O_j9DefVbfsDZ0E")
    Call<ResponseSaleClient> showRequestForPayment(@Path("id") int id);
}
