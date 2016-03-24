package org.xkonnex.repo.dsl.basedsl.test.util

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xkonnex.repo.dsl.basedsl.tests.BaseDslInjectorProvider
import org.xkonnex.repo.dsl.basedsl.util.JavaBeanMerger
import org.junit.Test

import static org.junit.Assert.*
import com.google.inject.Inject

@RunWith(XtextRunner)
@InjectWith(BaseDslInjectorProvider)
class JavaBeanMergerTest {
	
	@Inject
	private JavaBeanMerger merger
	
	@Test
	def testMerge () {
		val target = new SampleBean => [
			someString = "AAA"
			nestedBean = new NestedBean => [
				port = 8080
				ignoredPort = 8080
				wrapperPort = 8080
				flag = false
				ignoredFlag = true
				wrapperFlag = true
				sampleEnum = SampleEnum::TWO
				defaultSampleEnum = SampleEnum::TWO
				stringList = #["one", "two", "three"]
			]
		]
		val source = new SampleBean => [
			someString = "BBB"
			nestedBean = new NestedBean => [
				port = 8888
				flag = true
				sampleEnum = SampleEnum::THREE
				stringList = #["one", "two"]
			]
		]
		
		val SampleBean result = merger.merge(source, target)
		
		assertEquals("BBB", result.someString)
		assertEquals(8888, result.nestedBean.port)
		assertEquals(0, result.nestedBean.ignoredPort)
		assertEquals(8080, result.nestedBean.wrapperPort)
		assertEquals(true, result.nestedBean.flag)
		assertEquals(false, result.nestedBean.ignoredFlag)
		assertEquals(true, result.nestedBean.wrapperFlag)
		assertEquals(SampleEnum::THREE, result.nestedBean.sampleEnum)
		assertEquals(SampleEnum::TWO, result.nestedBean.defaultSampleEnum)
		assertEquals(2, result.nestedBean.stringList.size)
		
		assertEquals("BBB", target.someString)
		assertEquals(8888, target.nestedBean.port)
		assertEquals(true, target.nestedBean.flag)
	}
	
}