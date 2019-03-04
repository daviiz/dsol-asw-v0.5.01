package combatSysModel.DEM;

import combatSysModel.portType.entity_info;
import combatSysModel.portType.guidance_info;
import combatSysModel.portType.move_result;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class CM_Weapon extends CoupledModelBase {

    /**
     * X:
     */
    public InputPort<Double, Double, SimTimeDouble, entity_info> in_entity_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_result> in_move_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_guidance> in_wp_guidance;

    /**
     * Y:
     */
    public OutputPort<Double, Double, SimTimeDouble, move_result> out_move_result;
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.guidance_info> out_guidance_info;

    /**
     * component models
     */
    private Maneuver m;
    private Sensor s;
    private Controller c;

    public CM_Weapon(String modelName) {
        super(modelName);
    }

    public CM_Weapon(String modelName, TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public CM_Weapon(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    @Override
    public void constructPort() {
        /**
         * X
         */
        in_entity_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.entity_info>(this);
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result>(this);
        in_move_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_result>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info>(this);
        in_wp_guidance = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_guidance>(this);

        /**
         * Y
         */
        out_move_result = new OutputPort<Double, Double, SimTimeDouble, move_result>(this);
        out_guidance_info = new OutputPort<Double, Double, SimTimeDouble, guidance_info>(this);
    }

    @Override
    public void couplingComponent() {
        /**
         *  { Mi }
         */
        m = new Maneuver("Maneuver", this);
        s = new Sensor("Sensor", this);
        c = new Controller("Controller", this);
        /**
         * EIC
         */


        /**
         * EOC
         */


        /**
         * IC
         */
    }
}
