package org.xkonnex.repo.dsl.basedsl.test.util

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xkonnex.repo.dsl.basedsl.tests.BaseDslInjectorProvider
import org.xkonnex.repo.dsl.basedsl.util.JavaBeanMerger
import org.junit.Test

import static org.junit.Assert.*
import com.google.inject.Inject
import java.util.List

@RunWith(XtextRunner)
@InjectWith(BaseDslInjectorProvider)
class JavaBeanMergerTest {
	
	@Inject
	private JavaBeanMerger merger
	
	@Test
	def testMergeSourceTarget () {
		val target = new SampleBean => [
			someString = "AAA"
			nestedBean = new NestedBean => [
				port = 8888
				wrapperPort = 8080
				flag = true
				wrapperFlag = true
				sampleEnum = SampleEnum::THREE
				stringList = #["one", "two", "three"]
			]
		]
		val source = new SampleBean => [
			someString = "BBB"
			someOtherString = "Other"
			nestedBean = new NestedBean => [
				flag = false
				sampleEnum = SampleEnum::TWO
				stringList = #["one", "two"]
				emptyStringList = #["one", "two"]
				defaultSampleEnum = SampleEnum::TWO
			]
		]
		
		val SampleBean result = merger.merge(source, target)
		
		assertEquals("AAA", result.someString)
		assertEquals("Other", result.someOtherString)
		assertEquals(8888, result.nestedBean.port)
		assertEquals(0, result.nestedBean.ignoredPort)
		assertEquals(8080, result.nestedBean.wrapperPort)
		assertEquals(true, result.nestedBean.flag)
		assertEquals(false, result.nestedBean.ignoredFlag)
		assertEquals(true, result.nestedBean.wrapperFlag)
		assertEquals(SampleEnum::THREE, result.nestedBean.sampleEnum)
		assertEquals(SampleEnum::TWO, result.nestedBean.defaultSampleEnum)
		assertEquals(3, result.nestedBean.stringList.size)
		assertEquals(2, result.nestedBean.emptyStringList.size)
		
		assertEquals("AAA", target.someString)
		assertEquals(8888, target.nestedBean.port)
		assertEquals(true, target.nestedBean.flag)
	}
	
	@Test
	def testMergeBottomUp () {
		val bottom = new SampleBean => [
			someString = "AAA"
			nestedBean = new NestedBean => [
				port = 8888
				wrapperPort = 8080
				flag = true
				wrapperFlag = true
				sampleEnum = SampleEnum::THREE
				stringList = #["one", "two", "three"]
			]
		]
		val middle = new SampleBean => [
			someString = "BBB"
			nestedBean = new NestedBean => [
				flag = false
				sampleEnum = SampleEnum::TWO
				stringList = #["one", "two"]
				emptyStringList = #["one", "two"]
			]
		]
		val upper = new SampleBean => [
			someOtherString = "CCC"
			nestedBean = new NestedBean => [
				port = 8080
				flag = true
				ignoredPort = 8080
				ignoredFlag = true
				stringList = #["one", "two"]
				defaultSampleEnum = SampleEnum::TWO
			]
		]
		val List<SampleBean> bottomUpHierarchy = #[bottom, middle, upper]
		val SampleBean result = merger.merge(bottomUpHierarchy)
		
		assertEquals("AAA", result.someString)
		assertEquals("CCC", result.someOtherString)
		assertEquals(8888, result.nestedBean.port)
		assertEquals(0, result.nestedBean.ignoredPort)
		assertEquals(8080, result.nestedBean.wrapperPort)
		assertEquals(true, result.nestedBean.flag)
		assertEquals(false, result.nestedBean.ignoredFlag)
		assertEquals(true, result.nestedBean.wrapperFlag)
		assertEquals(SampleEnum::THREE, result.nestedBean.sampleEnum)
		assertEquals(SampleEnum::TWO, result.nestedBean.defaultSampleEnum)
		assertEquals(3, result.nestedBean.stringList.size)
		assertEquals(2, result.nestedBean.emptyStringList.size)
	}
	
	@Test
	def testMergeBottomUpTarget () {
		val bottom = new SampleBean => [
			someString = "AAA"
			nestedBean = new NestedBean => [
				port = 8888
				wrapperPort = 8080
				flag = true
				wrapperFlag = true
				sampleEnum = SampleEnum::THREE
				stringList = #["one", "two", "three"]
			]
		]
		val middle = new SampleBean => [
			someString = "BBB"
			nestedBean = new NestedBean => [
				flag = false
				sampleEnum = SampleEnum::TWO
				stringList = #["one", "two"]
			]
		]
		val upper = new SampleBean => [
			someOtherString = "CCC"
			nestedBean = new NestedBean => [
				port = 8080
				flag = true
				ignoredPort = 8080
				ignoredFlag = true
				stringList = #["one", "two"]
				defaultSampleEnum = SampleEnum::TWO
			]
		]
		val List<SampleBean> bottomUpHierarchy = #[bottom, middle, upper]
		val SampleBean result = merger.merge(bottomUpHierarchy, new SampleBean)
		
		assertEquals("AAA", result.someString)
		assertEquals("CCC", result.someOtherString)
		assertEquals(8888, result.nestedBean.port)
		assertEquals(0, result.nestedBean.ignoredPort)
		assertEquals(8080, result.nestedBean.wrapperPort)
		assertEquals(true, result.nestedBean.flag)
		assertEquals(false, result.nestedBean.ignoredFlag)
		assertEquals(true, result.nestedBean.wrapperFlag)
		assertEquals(SampleEnum::THREE, result.nestedBean.sampleEnum)
		assertEquals(SampleEnum::TWO, result.nestedBean.defaultSampleEnum)
		assertEquals(3, result.nestedBean.stringList.size)
	}
	
}