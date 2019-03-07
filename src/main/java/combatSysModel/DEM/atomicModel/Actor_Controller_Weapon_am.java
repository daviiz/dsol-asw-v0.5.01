package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.OM_Weapon_Controller;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

/**
 *
 */
public class Actor_Controller_Weapon_am extends AtomicModelBase<OM_Weapon_Controller> {

    public InputPort<Double,Double, SimTimeDouble, move_finished> in_move_finished;
    public InputPort<Double,Double, SimTimeDouble, engage_result> in_engage_result;
    public InputPort<Double,Double, SimTimeDouble, scen_info> in_scen_info;
    public InputPort<Double,Double, SimTimeDouble, wp_guidance> in_wp_guidance;
    public InputPort<Double,Double, SimTimeDouble, target_info> in_target_info;

    public OutputPort<Double,Double, SimTimeDouble, move_cmd> out_move_cmd;


    @Override
    protected void constructPort() {
        in_move_finished =new InputPort<Double, Double, SimTimeDouble, move_finished>(this);
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, engage_result>(this);
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, scen_info>(this);
        in_wp_guidance = new InputPort<Double, Double, SimTimeDouble, wp_guidance>(this);
        in_target_info = new InputPort<Double, Double, SimTimeDouble, target_info>(this);

        out_move_cmd = new OutputPort<Double, Double, SimTimeDouble, move_cmd>(this);
    }

    @Override
    protected void constructPhase() {

    }

    @Override
    protected void constructModelData() {

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

    public Actor_Controller_Weapon_am(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Actor_Controller_Weapon_am(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }


}
