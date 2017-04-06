package firstgrailsapp

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.web.GroovyPageUnitTestMixin
import spock.lang.Specification

import javax.xml.parsers.SAXParser

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(StaticPagesController)
@TestMixin(GroovyPageUnitTestMixin)
class StaticPagesControllerSpec extends Specification {

    def slurper

    def setup() {
        slurper = new XmlSlurper(new org.cyberneko.html.parsers.SAXParser())
    }

    def cleanup() {
    }

    void "test get home page"() {
        when:
        controller.home()

        then:
        response.status == 200
        response.text.contains 'Home | RoR Tutorial'
    }

    void 'test get help page'(){
        when:
            controller.help()
            def page = slurper.parseText response.text
            def titleTag = page.HEAD.TITLE.find { it.@text = 'Help | RoR Tutorial'}
        then:
            response.status == 200
            assert titleTag
    }

    void 'test should get about'(){
        when:
            controller.about()
        then:
            response.status == 200
            render(view: view) != null
    }
}
