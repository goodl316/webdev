package com.koreait.sboard;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.koreait.sboard.common.Const;
import com.koreait.sboard.model.ManageBoardEntity;

@Component("menuPreparer")
public class MenuPreparer implements ViewPreparer{
	
	@Autowired
	private CommonMapper mapper;
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		if(Const.menuList ==null) {
			System.out.println("--get menu from db--");
			Const.menuList = mapper.selManageBoardList();
		}
		attributeContext.putAttribute("menuList", new Attribute(Const.menuList), true);
		
	}
	
}
