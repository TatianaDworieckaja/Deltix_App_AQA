package tatiana_dworieckaja.deltixuat.tests;

import tatiana_dworieckaja.deltixuat.models.PostTradeResponse;
import tatiana_dworieckaja.deltixuat.utils.DeltixApi;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_AlgoPerformanceGridAPIResponseTest {


    @Test(groups = "NotFinished")
    public void TestDeltixAPIReturnDataAboutAlgoGrid() {
        DeltixApi deltixApi = new DeltixApi();
        PostTradeResponse response = deltixApi.getAlgoPerformanceGridResponse();
        Assert.assertNotNull(response);
    }
}
