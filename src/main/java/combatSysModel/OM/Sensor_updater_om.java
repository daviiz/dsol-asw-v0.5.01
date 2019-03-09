package combatSysModel.OM;

import combatSysModel.DEM.ObjectModelBase;
import combatSysModel.portType.entity_info;
import combatSysModel.portType.move_result;
import combatSysModel.portType.request;
import combatSysModel.portType.response;

import java.util.ArrayList;

public class Sensor_updater_om  extends ObjectModelBase {

    private move_result in_move_result;
    private request in_request;
    private response out_response;

    private ArrayList<entity_info> entitiesData;

    /**
     * 更新Sensor探测到的实体列表：
     * ArrayList<entity_info>
     * 识别并更新out_response值
     */
    public void data_intgrator(){

        //...
    }



    public move_result getIn_move_result() {
        return in_move_result;
    }

    public void setIn_move_result(move_result in_move_result) {
        this.in_move_result = in_move_result;
    }

    public request getIn_request() {
        return in_request;
    }

    public void setIn_request(request in_request) {
        this.in_request = in_request;
    }

    public response getOut_response() {
        return out_response;
    }

    public void setOut_response(response out_response) {
        this.out_response = out_response;
    }
}
