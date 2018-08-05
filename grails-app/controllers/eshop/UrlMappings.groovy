package eshop

class UrlMappings {

    static mappings = {
        "/static"(controller: 'store', action: 'stat')
        "/browse"(controller: 'store', action: 'browse')
        "/product"(controller: 'store', action: 'product')
        "/basket"(controller: 'store', action: 'basket')
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
