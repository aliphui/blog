package com.atguigu.blog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * Created by limi on 2017/10/22.
 */
public class MarkdownUtils {

    /**
     * markdown格式转换成HTML格式
     * @param markdown
     * @return
     */
    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    /**
     * 增加扩展[标题锚点，表格生成]
     * Markdown转换成HTML
     * @param markdown
     * @return
     */
    public static String markdownToHtmlExtensions(String markdown) {
        //h标题生成id
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的HTML
        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tableExtension)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(headingAnchorExtensions)
                .extensions(tableExtension)
                .attributeProviderFactory(new AttributeProviderFactory() {
                    public AttributeProvider create(AttributeProviderContext context) {
                        return new CustomAttributeProvider();
                    }
                })
                .build();
        return renderer.render(document);
    }

    /**
     * 处理标签的属性
     */
    static class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            //改变a标签的target属性为_blank
            if (node instanceof Link) {
                attributes.put("target", "_blank");
            }
            if (node instanceof TableBlock) {
                attributes.put("class", "ui celled table");
            }
        }
    }


    public static void main(String[] args) {
        String table = "## \t运算符\n" +
                "• 运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等。\n" +
                "#### \t• 分类：\n" +
                "\t\t○ 算术运算符\n" +
                "\t\t○ 赋值运算符\n" +
                "\t\t○ 比较运算符（关系运算符）\n" +
                "\t\t○ 逻辑运算符\n" +
                "\t\t○ 位运算符\n" +
                "\t\t○ 三元运算符\n" +
                "### 算术运算符\n" +
                "##### \t• 注意\n" +
                "\t\t○ 如果对负数取模，可以把模数负号忽略不记，被模数为正，则结果为正，被模数为负，则结果为负，如：5%-2=1；-5%-2=-1；此外，取模运算的结果不一定总是整数。\n" +
                "\t\t○ 对于除号“/”，它的整数除和小数除是有区别的：整数之间做除法时，只 保留整数部分而舍弃小数部分。 例如：int x=3510;x=x/1000*1000; x的结果是3000；\n" +
                "\t\t○ “+”除字符串相加功能外，还能把非字符串转换成字符串.例如： System.out.println(“5+5=”+5+5); //打印结果是：5+5=55 \n" +
                "### 赋值运算符\n" +
                "##### • 符号：=\n" +
                "\t当“=”两侧数据类型不一致时，可以使用自动类型转换或使用强制 类型转换原则进行处理。\n" +
                "\t支持连续赋值。\n" +
                "##### • 扩展赋值运算符：\n" +
                "\t+=, -=, *=, /=, %=\n" +
                "### 比较运算符（关系运算符）\n" +
                "\t比较运算符的结果都是boolean型，也就是要么是true，要么是false。\n" +
                "### 逻辑运算符\n" +
                "\t& ——逻辑与       && ——短路与\n" +
                "\t| ——逻辑或       || ——短路或\n" +
                "\t! ——逻辑非       ^ ——逻辑异或\n" +
                "##### • 注意\n" +
                "\t• 逻辑运算符用于连接布尔型（boolean：true或false）表达式，在Java中不可以写成不可以写成3<x<6，应该写 成x>3 & x<6\n" +
                "##### \t• “&”和“&&”的区别：\n" +
                "\t○ 单&时，左边无论真假，右边都进行运算；\n" +
                "\t○ 双&时，如果左边为真，右边参与运算，如果左边为假，那么右边不参与运算。\n" +
                "\t• “|”和“||”的区别同理，||表示：当左边为真，右边不参与运算。\n" +
                "##### \t• 异或( ^ )与或( | )的区别\n" +
                "\t当左右都为true时，结果为false。 \n" +
                "\t理解：异或，追求的是“异”!\n" +
                "### 位运算符\n" +
                " \n" +
                "### 三元运算符\n" +
                "##### • 格式：\n" +
                "\t（条件表达式）？表达式1：表达式2;\n" +
                "\t注意：表达式1和表达式2为同种类型\n" +
                "##### \t• 三元运算符与if-else的联系与区别：\n" +
                "\t\t○ 三元运算符可简化if-else语句\n" +
                "\t\t○ 三元运算符要求必须返回一个结果。\n" +
                "\t\t○ if后的代码块可有多个语句\n" +
                "\t\t可以用三元运算符的一定可以用if-else，反之不一定，\n" +
                "\t\t通常两者都可以用的情况下用三元运算符效率更高，\n" +
                "\t\tswitch语句和if-else的关系和这个类似\n" +
                "## 运算符的优先级\n" +
                "\t• 运算符有不同的优先级，所谓 优先级就是表达式运算中的运 算顺序。如上表，上一行运算 符总优先于下一行。 \n" +
                "\t只有单目运算符、三元运算符、 赋值运算符是从右向左运算的。";
        String a = "[imCoding 爱编程](http://www.lirenmi.cn)";
        System.out.println(markdownToHtmlExtensions(table));
    }
}
