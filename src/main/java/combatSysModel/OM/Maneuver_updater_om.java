package combatSysModel.OM;

import combatSysModel.DEM.ObjectModelBase;
import combatSysModel.portType.move_cmd;

public class Maneuver_updater_om  extends ObjectModelBase {

    private move_cmd move_cmd;
    private combatSysModel.portType.cmd_info cmd_info;

    public void cmd_Interpreter(){

    }

    public combatSysModel.portType.move_cmd getMove_cmd() {
        return move_cmd;
    }

    public void setMove_cmd(combatSysModel.portType.move_cmd move_cmd) {
        this.move_cmd = move_cmd;
    }

    public combatSysModel.portType.cmd_info getCmd_info() {
        return cmd_info;
    }

    public void setCmd_info(combatSysModel.portType.cmd_info cmd_info) {
        this.cmd_info = cmd_info;
    }
}
