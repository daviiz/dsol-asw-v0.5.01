package combatSysModel.DEM;

import combatSysModel.BasedCoupledModel;
import combatSysModel.portType.move_result;
import combatSysModel.portType.wp_guidance;
import combatSysModel.portType.wp_launch;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class CM_Platform extends BasedCoupledModel {

    /**
     * X:
     */
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info> in_scen_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_result> in_move_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.guidance_info> in_guidance_info;

    /**
     * Y:
     */
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_result> out_move_result;
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_launch> out_wp_launch;
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_guidance> out_wp_guidance;

    /**
     * component models
     */
    private Maneuver m;
    private Sensor s;
    private Controller c;

    public CM_Platform(String modelName) {
        super(modelName);
    }

    public CM_Platform(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public CM_Platform(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    @Override
    public void constructModel() {
        /**
         * X
         */
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info>(this);
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result>(this);
        in_move_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_result>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info>(this);
        in_guidance_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.guidance_info>(this);

        /**
         * Y
         */
        out_move_result = new OutputPort<Double, Double, SimTimeDouble, move_result>(this);
        out_wp_launch = new OutputPort<Double, Double, SimTimeDouble, wp_launch>(this);
        out_wp_guidance = new OutputPort<Double, Double, SimTimeDouble, wp_guidance>(this);

        /**
         *  { Mi }
         */
        m = new Maneuver("Maneuver", this);
        s = new Sensor("Sensor", this);
        c = new Controller("Controller", this);
        /**
         * EIC
         */
        this.addExternalInputCoupling(this.in_scen_info, s.in_scen_info);
        this.addExternalInputCoupling(this.in_scen_info, m.in_scen_info);
        this.addExternalInputCoupling(this.in_engage_result, m.in_engage_result);
        this.addExternalInputCoupling(this.in_engage_result, s.in_engage_result);
        this.addExternalInputCoupling(this.in_engage_result, c.in_engage_result);
        this.addExternalInputCoupling(this.in_move_result, s.in_move_result);
        this.addExternalInputCoupling(this.in_env_info, m.in_env_info);
        this.addExternalInputCoupling(this.in_env_info, s.in_env_info);
        this.addExternalInputCoupling(this.in_env_info, c.in_env_info);
        this.addExternalInputCoupling(this.in_guidance_info, m.in_guidance_info);

        /**
         * EOC
         */
        this.addExternalOutputCoupling(m.out_move_result, this.out_move_result);
        this.addExternalOutputCoupling(c.out_wp_launch, this.out_wp_launch);
        this.addExternalOutputCoupling(m.out_wp_guidance, this.out_wp_guidance);

        /**
         * IC
         */
        this.addInternalCoupling(s.out_threat_info, c.in_threat_info);
        this.addInternalCoupling(c.out_move_cmd, m.in_move_cmd);
        this.addInternalCoupling(m.out_move_finished, c.in_move_finished);
        this.addInternalCoupling(m.out_fuel_exhausted, s.in_fuel_exhausted);
        this.addInternalCoupling(m.out_fuel_exhausted, c.in_fuel_exhausted);
    }
}
