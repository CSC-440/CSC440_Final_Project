function init(){
    run_cloud9_setup_scripts
    startup_mongo
    run_project
}

function run_cloud9_setup_scripts(){
    local called_from_directory="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
    local setup_script_name_and_path=$(printf "%s/z_scripts/setup_c9_to_work_on_repo.bash" $called_from_directory)  
    bash $setup_script_name_and_path
}

function startup_mongo(){
    bash mongodb_run.bash
}

function run_project(){
    mvn spring-boot:run
}

init