
function say_hello(){
    printf "\n";
    printf "%s\n" "$intro_message";
    printf "\n";
}

function display_repo_being_clones(){
    printf "\n";
    printf "Cloning Repo with ssh. URL : %s\n" "$repo_url";
    printf "\n";
}

function set_variables(){
    intro_message="Hello World!";
    repo_url="git@github.com:CSC-440/CSC440_Final_Project.git"
}

function clone_repo(){
    git clone $repo_url project_demo
}

function run_project(){
    cd project_demo
    bash Y_RUNME.bash
}
function init(){
    local intro_message;
    local repo_url;

    set_variables;
    say_hello;
    display_repo_being_clones;
    clone_repo;
    run_project;
}

init
