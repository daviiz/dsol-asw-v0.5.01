package combatSysModel.OM;

import combatSysModel.DEM.ObjectModelBase;
import combatSysModel.portType.*;

public class Maneuver_actor_om  extends ObjectModelBase {
    private engage_result engage_result;
    private scen_info scen_info;
    private env_info env_info;
    private cmd_info cmd_info;

    private move_finished move_finished;
    private move_result move_result;
    private fuel_exhausted fuel_exhausted;

    private boolean cmdCheckResult ;
    private boolean fuelCheckResult ;

    public boolean cmd_Check(){
        return this.cmdCheckResult;
    }

    public boolean fuel_Check(){
        return this.fuelCheckResult;
    }

    public void motion_Equation(){

    }


    public boolean isCmdCheckResult() {
        return cmdCheckResult;
    }

    public void setCmdCheckResult(boolean cmdCheckResult) {
        this.cmdCheckResult = cmdCheckResult;
    }

    public boolean isFuelCheckResult() {
        return fuelCheckResult;
    }

    public void setFuelCheckResult(boolean fuelCheckResult) {
        this.fuelCheckResult = fuelCheckResult;
    }

    public combatSysModel.portType.engage_result getEngage_result() {
        return engage_result;
    }

    public void setEngage_result(combatSysModel.portType.engage_result engage_result) {
        this.engage_result = engage_result;
    }

    public combatSysModel.portType.scen_info getScen_info() {
        return scen_info;
    }

    public void setScen_info(combatSysModel.portType.scen_info scen_info) {
        this.scen_info = scen_info;
    }

    public combatSysModel.portType.env_info getEnv_info() {
        return env_info;
    }

    public void setEnv_info(combatSysModel.portType.env_info env_info) {
        this.env_info = env_info;
    }

    public combatSysModel.portType.cmd_info getCmd_info() {
        return cmd_info;
    }

    public void setCmd_info(combatSysModel.portType.cmd_info cmd_info) {
        this.cmd_info = cmd_info;
    }

    public combatSysModel.portType.move_finished getMove_finished() {
        return move_finished;
    }

    public void setMove_finished(combatSysModel.portType.move_finished move_finished) {
        this.move_finished = move_finished;
    }

    public combatSysModel.portType.move_result getMove_result() {
        return move_result;
    }

    public void setMove_result(combatSysModel.portType.move_result move_result) {
        this.move_result = move_result;
    }

    public combatSysModel.portType.fuel_exhausted getFuel_exhausted() {
        return fuel_exhausted;
    }

    public void setFuel_exhausted(combatSysModel.portType.fuel_exhausted fuel_exhausted) {
        this.fuel_exhausted = fuel_exhausted;
    }
}