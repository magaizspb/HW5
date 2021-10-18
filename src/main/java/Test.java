

import retrofit.api.MiniMarketApi;
import retrofit.utils.RetrofitGetter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class Test {
    //
    public static void main(String[] args) throws IOException {
        RetrofitGetter getter = new RetrofitGetter();

        Retrofit retrofit = getter.getInstance();

        MiniMarketApi marketApi = retrofit.create(MiniMarketApi.class);

        Response<List<dto.ProductDto>> productsResp = marketApi.getProducts().execute();
//
//

    }
}
