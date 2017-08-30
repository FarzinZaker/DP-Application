package sampleapplication

import grails.converters.JSON

import java.math.MathContext

class UserController {

    def insert() {
//        println "insert"
        render(new User(firstName: params.fName, lastName: params.lName).save(flush: true)?.toString())
//        Thread.sleep(30)
//        render "Insert completed"
    }

    def update() {
//        println "update"
        def user = User.get(params.id as Long)
        user.firstName = params.fName
        user.lastName = params.lName
        render(user.save(flush: true)?.toString())
//        Thread.sleep(35)
//        render "Update completed"
    }

    def delete() {
//        println "delete"
        User.get(params.id).delete(flush: true)
//        Thread.sleep(25)
        render "Delete completed: ${params.id}"
    }

    def select() {
        println "select"
        render(User.list([max: 10])?.collect { it?.toString() }?.join("<br/>"))
//        Thread.sleep(50)
//        render "Select completed"
    }

    def pi() {
//        println "pi ${params.id}"
        def sum = new BigDecimal(0)
        for (def i = 0; i < (params.id as Integer); i++)
            sum += new BigDecimal(-3).pow(-i, MathContext.DECIMAL128).divide(2 * i + 1, MathContext.DECIMAL128)
        render sum * new BigDecimal(Math.sqrt(12))
    }
}
