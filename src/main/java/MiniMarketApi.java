


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MiniMarketApi {

    @GET("/market/api/v1/products")
    Call<List<dto.ProductDto>> getProducts();

    @GET("/market/api/v1/products/{id}")
    Call<dto.ProductDto> getProduct(@Path("id") long id);

    @POST("/market/api/v1/products")
    Call<dto.ProductDto> createProduct(@Body dto.ProductDto product);

    @PUT("/market/api/v1/products")
    Call<dto.ProductDto> updateProduct(@Body dto.ProductDto product);

    @DELETE("/market/api/v1/products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") long id);
//
}
