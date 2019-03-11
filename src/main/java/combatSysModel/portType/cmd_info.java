package combatSysModel.portType;

import combatSysModel.DEM.PortTypeBase;

public class cmd_info extends PortTypeBase {
    public COMMAND cmd;
    public cmd_info(){
        cmd = COMMAND.DEFAULT;
    }
}
