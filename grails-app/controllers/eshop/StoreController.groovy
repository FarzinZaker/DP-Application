package eshop

import grails.converters.JSON

class StoreController {

    static random = Random.newInstance()

    def stat() {
        def content = new File('/opt/tomcat/webapps/ROOT/assets/image.jpg').readBytes()
//        println 'static'
        response.contentType = 'image/jpeg'
        response.outputStream << content
        response.outputStream.flush()
    }

    def browse() {
        factorial(200)
        50.times {
            eshop.Product.createCriteria().list {
                gt('id', random.nextLong() % 1000)
                maxResults(20)
            }
        }

        def list = eshop.Product.createCriteria().list {
            gt('id', random.nextLong() % 1000)
            maxResults(20)
        }

//        println 'browse'
        render(list as JSON)
    }

    def product() {
        factorial(150)
        50.times {
            eshop.Product.createCriteria().list {
                gt('id', random.nextLong() % 1000)
                maxResults(1)
            }
        }
        def product = eshop.Product.createCriteria().list {
            gt('id', random.nextLong() % 1000)
            maxResults(1)
        }?.find()
//        println 'product'
        render((product ?: [:]) as JSON)
    }

    def basket() {
        factorial(100)
        50.times {
            eshop.Product.createCriteria().list {
                gt('id', random.nextLong() % 1000)
                maxResults(1)
            }
        }
        def product = eshop.Product.createCriteria().list {
            gt('id', random.nextLong() % 1000)
            maxResults(1)
        }?.find()
        if (product) {
            product.saleCount++
            product.save()
        }
//        println 'basket'
        render(product.saleCount ?: 0)
    }

    private static BigDecimal factorial(int value) {
        if (value == 0)
            return 1
        return factorial(value - 1) * value
    }
}
