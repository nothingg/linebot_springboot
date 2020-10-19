package com.ghb.linebot.flex;

import java.util.function.Supplier;

import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.Box;
import com.linecorp.bot.model.message.flex.component.Separator;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.component.Text.TextWeight;
import com.linecorp.bot.model.message.flex.component.Image;
import com.linecorp.bot.model.message.flex.component.Image.ImageSize;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexAlign;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexGravity;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class ReceiptFlexMessageSupplier implements Supplier<FlexMessage> {
    @Override
    public FlexMessage get() {
        final Separator separator = Separator.builder().margin(FlexMarginSize.XXL).build();
        final Box headerBlock = createBodyHeaderBox();
        final Box itemBlock = createBodyItemBlock();
        final Box summaryBlock = createBodySummaryBlock();
        final Box footBlock = createBoxFooterBlock();

        final Box bodyBlock = Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(asList(
                        headerBlock,
                        separator,
                        itemBlock,
                        separator,
                        summaryBlock,
                        separator,
                        footBlock))
                .build();

        final Bubble bubble = Bubble.builder()
                .body(bodyBlock)
                .build();
        
        return new FlexMessage("Rep", bubble);
    }

   
	

	private Box createBodyHeaderBox() {
		
        final Text bodyHeaderText = Text.builder()
                .text("Transaction")
                .weight(Text.TextWeight.BOLD)
                .color("#1db446")
                .size(FlexFontSize.SM)
                .build();
        final Text bodyTitleHeaderText = Text.builder()
                .text("MR.GHB ForHome")
                .weight(Text.TextWeight.BOLD)
                .size(FlexFontSize.XL)
                .margin(FlexMarginSize.MD)
                .build();
        final Text bodyTitleHeaderDetail = Text.builder()
                .text("001-15-000000-0")
                .size(FlexFontSize.XS)
                .color("#aaaaaa")
                .build();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(asList(
                		bodyHeaderText,
                        bodyTitleHeaderText,
                        bodyTitleHeaderDetail))
                .build();
    }
	
	private Box createBodyItemBlock() {
    	final Box item1 = createItem("Widthdraw","1,000.00");
    	
		return Box.builder()
				.layout(FlexLayout.VERTICAL)
				.margin(FlexMarginSize.XXL)
				.spacing(FlexMarginSize.SM)
				.contents(asList(item1))
				.build();
	}
    
    private Box createItem(String name, String price) {
    	
        return Box.builder()
                .layout(FlexLayout.HORIZONTAL)
                .contents(asList(
                        Text.builder()
                                .text(name)
                                .size(FlexFontSize.SM)
                                .color("#555555")
                                .flex(0)
                                .build(),
                        Text.builder()
                                .text(price)
                                .size(FlexFontSize.SM)
                                .color("#111111")
                                .align(FlexAlign.END)
                                .build()
                )).build();
    }
	
	 private Box createBodySummaryBlock() {

		 final Text bodyFooterText = Text.builder()
	    		.text("Balance")
	    		.weight(TextWeight.BOLD)
	    		.size(FlexFontSize.SM)
	    		.align(FlexAlign.START)
	    		.build();
		 final Text bodyFooterAmt = Text.builder()
				 .text("1,000.00")
				 .align(FlexAlign.END)
				 .size(FlexFontSize.SM)
				 .build();
		 
		 
		 return Box.builder().layout(FlexLayout.HORIZONTAL)
				 .contents(asList(
						 bodyFooterText,
						 bodyFooterAmt))
				 .margin(FlexMarginSize.XXL)
				 .spacing(FlexMarginSize.SM)
				 .build();
		}
	 
	 private Box createBoxFooterBlock() {
		 final Image bodyFooterImage = Image.builder()
				 							.url("https://www.ghbank.co.th/assets/img/logo-ghb.png")
				 							.align(FlexAlign.CENTER)
				 							.size(ImageSize.XXS)
				 							.build();
		 
		 return Box.builder()
				 .layout(FlexLayout.VERTICAL)
				 .contents(asList(bodyFooterImage))
				 .build();
	 }
}