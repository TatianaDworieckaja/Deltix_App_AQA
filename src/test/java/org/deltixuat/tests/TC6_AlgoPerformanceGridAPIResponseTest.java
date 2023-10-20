package org.deltixuat.tests;

import org.deltixuat.models.PostTradeResponse;
import org.deltixuat.utils.DeltixApi;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_AlgoPerformanceGridAPIResponseTest {


    @Test
    public void TestDeltixAPIReturnDataAboutAlgoGrid() {
        DeltixApi deltixApi = new DeltixApi();
        PostTradeResponse response = deltixApi.getAlgoPerformanceGridResponse();
        Assert.assertNotNull(response);
    }
}
