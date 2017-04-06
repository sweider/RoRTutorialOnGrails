package firstgrailsapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "Hello", action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
