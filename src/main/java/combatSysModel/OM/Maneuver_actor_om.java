package combatSysModel.OM;

import asw.soa.data.ModelData;
import asw.soa.util.SimUtil;
import combatSysModel.DEM.ObjectModelBase;
import combatSysModel.portType.*;
import nl.tudelft.simulation.language.d3.CartesianPoint;

public class Maneuver_actor_om  extends ObjectModelBase {
    //获取到的交战结果：
    private engage_result engage_result;
    //初始化时，加载模型数据：
    private scen_info scen_info;
    //获取到的探测信息：
    private env_info env_info;
    //收到的命令信息：
    private cmd_info cmd_info;

    //输出的消息：
    private move_finished move_finished;
    private move_result move_result;
    private fuel_exhausted fuel_exhausted;

    private boolean cmdCheckResult ;
    private boolean fuelCheckResult ;

    private  ModelData modelData;

    public Maneuver_actor_om(){

        engage_result = new engage_result();
        scen_info = new scen_info();
        env_info = new env_info();
        cmd_info = new cmd_info();
        move_finished = new move_finished();
        move_result = new move_result();
        fuel_exhausted = new fuel_exhausted();
        cmdCheckResult = false;
        fuelCheckResult = false;

        //测试用：
        this.env_info.location = new CartesianPoint(500.0,500.0,0.0);

        //模型初始化：
        //modelData = new ModelData("Fleet");
        //modelData.origin = modelData.destination = new CartesianPoint(-200, -50, 0);
    }



    public void motion_Equation(){
        this.modelData.origin = this.modelData.destination;

        if (!this.modelData.status) {
            this.modelData.destination = new CartesianPoint(modelData.destination.x, modelData.destination.y, 0);
        } else {
            modelData.destination = SimUtil.nextPoint(this.modelData.origin.x,this.modelData.origin.y,this.env_info.location.x,this.env_info.location.y,
                    this.modelData.speed,(cmd_info.cmd==COMMAND.DEFAULT));
            //modelData.destination = new CartesianPoint(modelData.origin.x+modelData.speed, modelData.origin.y+modelData.speed, 0);
            this.move_result.location = modelData.destination;
            this.move_result.camp = modelData.belong;
            this.move_finished.isFinished = true;
        }
    }

    public ModelData getModelData() {
        return modelData;
    }

    public void setModelData(ModelData modelData) {
        this.modelData = modelData;
    }

    public boolean cmd_Check(){
        this.cmdCheckResult = false;
        return false;
    }

    public boolean fuel_Check(){
        this.fuelCheckResult = false;
        return false;
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