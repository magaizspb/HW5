
import org.junit.jupiter.api.Test;
import retrofit.api.MiniMarketApi;
import retrofit.dto.Category;
import retrofit.dto.ProductDto;
import retrofit.utils.RetrofitGetter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ApiTest {
//

    private final MiniMarketApi api;

    public ApiTest() throws IOException {
        Retrofit retrofit = new RetrofitGetter().getInstance();
        api = retrofit.create(MiniMarketApi.class);
    }

    @Test
    void testCreateProduct() throws IOException {

        ProductDto dto = ProductDto.builder()
                .title("Water")
                .categoryTitle(Category.FOOD.getTitle())
                .price(15L)
                .build();

        Response<ProductDto> response = api.createProduct(dto).execute();
        Long id = response.body().getId();

        ProductDto actually = api.getProduct(id).execute().body();

        assertEquals(dto.getTitle(), actually.getTitle());
        assertEquals(dto.getPrice(), actually.getPrice());
        assertEquals(dto.getCategoryTitle(), actually.getCategoryTitle());

        api.deleteProduct(id).execute();
    }
}
