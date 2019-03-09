package combatSysModel.OM;

import combatSysModel.DEM.ObjectModelBase;
import combatSysModel.portType.*;

public class Platform_Controller_actor_om  extends ObjectModelBase {
    private move_finished in_move_finished;
    private engage_result in_engage_result;
    private env_info in_env_info;
    private guidance_info in_guidance_info;
    private target_info in_target_info;
    private scen_info in_scen_info;

    private move_cmd out_move_cmd;
    private wp_launch out_wp_launch;
    private wp_guidance out_wp_guidance;

    private String apprchNextPhase = "";

    public void Recom(){

    }

    public void Apprch(){

    }

    public void Combat(){

    }

    public void Evasion(){

    }

    public void Ctrl(){

    }

    public String getApprchNextPhase() {
        return apprchNextPhase;
    }

    public void setApprchNextPhase(String apprchNextPhase) {
        this.apprchNextPhase = apprchNextPhase;
    }

    public scen_info getIn_scen_info() {
        return in_scen_info;
    }

    public void setIn_scen_info(scen_info in_scen_info) {
        this.in_scen_info = in_scen_info;
    }

    public move_finished getIn_move_finished() {
        return in_move_finished;
    }

    public void setIn_move_finished(move_finished in_move_finished) {
        this.in_move_finished = in_move_finished;
    }

    public engage_result getIn_engage_result() {
        return in_engage_result;
    }

    public void setIn_engage_result(engage_result in_engage_result) {
        this.in_engage_result = in_engage_result;
    }

    public env_info getIn_env_info() {
        return in_env_info;
    }

    public void setIn_env_info(env_info in_env_info) {
        this.in_env_info = in_env_info;
    }

    public guidance_info getIn_guidance_info() {
        return in_guidance_info;
    }

    public void setIn_guidance_info(guidance_info in_guidance_info) {
        this.in_guidance_info = in_guidance_info;
    }

    public target_info getIn_target_info() {
        return in_target_info;
    }

    public void setIn_target_info(target_info in_target_info) {
        this.in_target_info = in_target_info;
    }

    public move_cmd getOut_move_cmd() {
        return out_move_cmd;
    }

    public void setOut_move_cmd(move_cmd out_move_cmd) {
        this.out_move_cmd = out_move_cmd;
    }

    public wp_launch getOut_wp_launch() {
        return out_wp_launch;
    }

    public void setOut_wp_launch(wp_launch out_wp_launch) {
        this.out_wp_launch = out_wp_launch;
    }

    public wp_guidance getOut_wp_guidance() {
        return out_wp_guidance;
    }

    public void setOut_wp_guidance(wp_guidance out_wp_guidance) {
        this.out_wp_guidance = out_wp_guidance;
    }

}
