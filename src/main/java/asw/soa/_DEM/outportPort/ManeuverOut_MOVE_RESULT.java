package asw.soa._DEM.outportPort;

import asw.soa._DEM.portType.MoveResult;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.AtomicModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;

public class ManeuverOut_MOVE_RESULT extends OutputPort<Double, Double, SimTimeDouble, MoveResult> {
    public ManeuverOut_MOVE_RESULT(CoupledModel<Double, Double, SimTimeDouble> coupledModel) {
        super(coupledModel);
    }

    public ManeuverOut_MOVE_RESULT(AtomicModel<Double, Double, SimTimeDouble> atomicModel) {
        super(atomicModel);
    }
}
