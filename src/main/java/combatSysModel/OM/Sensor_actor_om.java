package combatSysModel.OM;

import combatSysModel.DEM.ObjectModelBase;
import combatSysModel.portType.*;

public class Sensor_actor_om  extends ObjectModelBase {
    private engage_result in_engage_result;
    private env_info in_env_info;
    private scen_info in_scen_info;
    private response in_response;

    private threat_info out_threat_info;
    private request out_request;

    /**
     * update out threat_info
     */
    public void detection_algrithm(){

    }


    public engage_result getIn_engage_result() {
        return in_engage_result;
    }

    public void setIn_engage_result(engage_result in_engage_result) {
        this.in_engage_result = in_engage_result;
    }

    public env_info getIn_env_info() {
        return in_env_info;
    }

    public void setIn_env_info(env_info in_env_info) {
        this.in_env_info = in_env_info;
    }

    public scen_info getIn_scen_info() {
        return in_scen_info;
    }

    public void setIn_scen_info(scen_info in_scen_info) {
        this.in_scen_info = in_scen_info;
    }

    public response getIn_response() {
        return in_response;
    }

    public void setIn_response(response in_response) {
        this.in_response = in_response;
    }

    public threat_info getOut_threat_info() {
        return out_threat_info;
    }

    public void setOut_threat_info(threat_info out_threat_info) {
        this.out_threat_info = out_threat_info;
    }

    public request getOut_request() {
        return out_request;
    }

    public void setOut_request(request out_request) {
        this.out_request = out_request;
    }
}
