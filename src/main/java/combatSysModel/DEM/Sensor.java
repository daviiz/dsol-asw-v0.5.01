package combatSysModel.DEM;

import combatSysModel.BasedCoupledModel;
import combatSysModel.portType.fuel_exhausted;
import combatSysModel.portType.threat_info;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

class Sensor extends BasedCoupledModel {

    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info> in_scen_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_result> in_move_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, fuel_exhausted> in_fuel_exhausted;

    public OutputPort<Double, Double, SimTimeDouble, threat_info> out_threat_info;


    public Sensor(String modelName) {
        super(modelName);
    }

    public Sensor(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Sensor(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
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
        in_fuel_exhausted = new InputPort<Double, Double, SimTimeDouble, fuel_exhausted>(this);
        /**
         * Y
         */
        out_threat_info = new OutputPort<Double, Double, SimTimeDouble, threat_info>(this);
    }
}
