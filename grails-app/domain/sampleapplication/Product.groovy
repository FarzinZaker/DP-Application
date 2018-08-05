package eshop

class Product extends BaseProduct {

    String name
    String description
    String details
    String manufactureDate
    String manufactureCountry
    String otherAtributes
    Double weight = 0D
    String keywords
    String pageTitle
    Boolean manualTitle
    String iranCode
    String shabnamCode
    Double length
    Double width
    Double height
    Integer visitCount = 0
    Integer saleCount = 0
    Boolean isVisible = true
    Boolean deleted = false
    Boolean isSynchronized = false

    Double currentPrice

    String searchKeys

    Product copySource

    Long sequenceNumber

    String productTypeNames
    String guaranteeNames
    String brandName

    static transients = ['title', 'currentPrice', 'breadCrumb', 'searchString', 'code']

    static mapping = {
        sort 'name'
        details type: "text"
        version false
        searchKeys type: 'text'
        isSynchronized index: 'index_isSynchronized'
        sequenceNumber index: 'index_sequenceNumber'
        isVisible index: 'index_mostVisited,index_deleted_isVisible'
        deleted index: 'index_mostVisited,index_deleted_isVisible'
        visitCount index: 'index_mostVisited', order: 'desc'
        id index: 'index_id_deleted_isVisible'
    }

    static constraints = {
        name(nullable: true)
        description(nullable: true, maxSize: 10000)
        manufactureCountry(nullable: true)
        manufactureDate(nullable: true)
        otherAtributes(nullable: true)
        details(nullable: true)
        weight(nullable: true)
        keywords(nullable: true)
        pageTitle(nullable: true)
        iranCode(nullable: true)
        shabnamCode(nullable: true)
        manualTitle(nullable: true)
        length nullable: true
        width nullable: true
        height nullable: true
        visitCount(nullable: true)
        isVisible(nullable: true)
        deleted(nullable: true)
        searchKeys(nullable: true)
        copySource(nullable: true)
        sequenceNumber(nullable: true)

        brandName nullable: true
        guaranteeNames nullable: true
        productTypeNames nullable: true
    }
}
