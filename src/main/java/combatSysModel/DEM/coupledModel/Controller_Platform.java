package combatSysModel.DEM.coupledModel;

import combatSysModel.DEM.CoupledModelBase;
import combatSysModel.DEM.atomicModel.Controller_Platform_Actor;
import combatSysModel.DEM.atomicModel.Controller_Platform_Updater;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class Controller_Platform extends CoupledModelBase {

    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.threat_info> in_threat_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_finished> in_move_finished;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.fuel_exhausted> in_fuel_exhausted;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.guidance_info> in_guidance_info;

    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_launch> out_wp_launch;
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_cmd> out_move_cmd;
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_guidance> out_wp_guidance;

    private Controller_Platform_Actor actor;
    private Controller_Platform_Updater updater;

    public Controller_Platform(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    public Controller_Platform(String modelName) {
        super(modelName);
    }

    public Controller_Platform(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    @Override
    protected void constructPort() {
        /**
         * X
         */
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info>(this);
        in_threat_info = new InputPort<Double, Double, SimTimeDouble, threat_info>(this);
        in_move_finished = new InputPort<Double, Double, SimTimeDouble, move_finished>(this);
        in_fuel_exhausted = new InputPort<Double, Double, SimTimeDouble, fuel_exhausted>(this);
        in_guidance_info = new InputPort<Double, Double, SimTimeDouble, guidance_info>(this);
        /**
         * Y
         */
        out_wp_launch = new OutputPort<Double, Double, SimTimeDouble, wp_launch>(this);
        out_move_cmd = new OutputPort<Double, Double, SimTimeDouble, move_cmd>(this);
        out_wp_guidance = new OutputPort<Double, Double, SimTimeDouble, wp_guidance>(this);
    }

    @Override
    protected void couplingComponent() {
        actor = new Controller_Platform_Actor("Actor",this);
        updater = new Controller_Platform_Updater("Updater",this);
        /**
         * EIC
         */
        this.addExternalInputCoupling(this.in_move_finished,actor.in_move_finished);
        this.addExternalInputCoupling(this.in_engage_result,actor.in_engage_result);
        this.addExternalInputCoupling(this.in_env_info,actor.in_env_info);
        this.addExternalInputCoupling(this.in_env_info,updater.in_env_info);
        this.addExternalInputCoupling(this.in_threat_info,updater.in_threat_info);
        this.addExternalInputCoupling(this.in_guidance_info,actor.in_guidance_info);
        /**
         * EOC
         */
        this.addExternalOutputCoupling(actor.out_move_cmd,this.out_move_cmd);
        this.addExternalOutputCoupling(actor.out_wp_launch,this.out_wp_launch);
        this.addExternalOutputCoupling(actor.out_wp_guidance,this.out_wp_guidance);
        /**
         * IC
         */
        this.addInternalCoupling(updater.out_target_info,actor.in_target_info);


    }


}
