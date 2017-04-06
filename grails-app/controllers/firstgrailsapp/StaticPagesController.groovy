package firstgrailsapp

class StaticPagesController {

    def home() {
        render view: 'home'
    }

    def help() {
        render view: 'help'
    }

    def about(){
        render view: 'about'
    }
}
