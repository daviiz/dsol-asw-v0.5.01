package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.OM_Platform_Controller;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.Phase;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Actor_Controller_Platform_am extends AtomicModelBase<OM_Platform_Controller> {

    public InputPort<Double, Double, SimTimeDouble, move_finished> in_move_finished;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, guidance_info> in_guidance_info;
    public InputPort<Double, Double, SimTimeDouble, target_info> in_target_info;

    public OutputPort<Double, Double, SimTimeDouble, move_cmd> out_move_cmd;
    public OutputPort<Double, Double, SimTimeDouble, wp_launch> out_wp_launch;
    public OutputPort<Double, Double, SimTimeDouble, wp_guidance> out_wp_guidance;

    private Phase IDLE,RECONNAIASSANCE,APPROACH,COMBAT,EVASION,CONTROL,END;

    @Override
    protected void constructPort() {
        in_move_finished = new InputPort<Double, Double, SimTimeDouble, move_finished>(this);
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, engage_result>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, env_info>(this);
        in_guidance_info = new InputPort<Double, Double, SimTimeDouble, guidance_info>(this);
        in_target_info = new InputPort<Double, Double, SimTimeDouble, target_info>(this);

        out_move_cmd = new OutputPort<Double, Double, SimTimeDouble, move_cmd>(this);
        out_wp_launch = new OutputPort<Double, Double, SimTimeDouble, wp_launch>(this);
        out_wp_guidance = new OutputPort<Double, Double, SimTimeDouble, wp_guidance>(this);
    }

    @Override
    protected void constructPhase() {
        IDLE = new Phase("IDLE");
        IDLE.setLifeTime(Double.POSITIVE_INFINITY);

        RECONNAIASSANCE = new Phase("RECONNAIASSANCE");
        RECONNAIASSANCE.setLifeTime(10.0);

        APPROACH = new Phase("APPROACH");
        APPROACH.setLifeTime(10.0);

        COMBAT = new Phase("COMBAT");
        COMBAT.setLifeTime(10.0);

        EVASION = new Phase("EVASION");
        EVASION.setLifeTime(10.0);

        CONTROL = new Phase("CONTROL");
        CONTROL.setLifeTime(10.0);

        END = new Phase("END");
        END.setLifeTime(Double.POSITIVE_INFINITY);

    }

    @Override
    protected void deltaExternalFunc(Object value) {

    }

    @Override
    protected void deltaInternalFunc() {

    }

    @Override
    protected void lambdaFunc() {

    }

    public Actor_Controller_Platform_am(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Actor_Controller_Platform_am(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }


}
