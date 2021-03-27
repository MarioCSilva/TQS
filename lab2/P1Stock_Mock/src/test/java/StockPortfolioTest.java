import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StockPortfolioTest {
    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortfolio portfolio;

    @Test
    void getTotalValueTest() {
        when(market.getPrice("EBAY")).thenReturn(4.0);
        when(market.getPrice("MSFT")).thenReturn(1.5);

        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("MSFT", 4));

        double result = portfolio.getTotalValue();

        assertEquals(14.0, result);
        // using hamcrest
        assertThat(result, is(14.0));

        verify(market, times(2)).getPrice(anyString());
    }
}