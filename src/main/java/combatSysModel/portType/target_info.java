package combatSysModel.portType;

import combatSysModel.DEM.PortTypeBase;

public class target_info   extends PortTypeBase {
    private env_info info;

    public void setEnv_info(env_info _info){
        this.info = _info;
    }
}
