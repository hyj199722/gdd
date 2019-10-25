import com.mju.band3.web.Controller.WaybillController;
import org.junit.Test;

public class dateFormatTest {
    @Test
    public void test1(){
        WaybillController waybillController=new WaybillController();
        if (waybillController.isRqFormat("2019-02-28")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
