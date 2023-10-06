package com.example.demo.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.ConstantsTag.ConstantsTag;
import com.example.demo.Repositories.DetailRepositorie;
import com.example.demo.Repositories.RecuRepositorie;
import com.example.demo.Repositories.TagRepositories;
import com.example.demo.models.Detail;
import com.example.demo.models.Recus;
import com.example.demo.models.TagRecus;

@Service
public class RecusService {
	@Autowired
	private RecuRepositorie repository;

	@Autowired
	private DetailRepositorie detailRepositorie;
	
	@Autowired
	private TagRepositories tagRepositories;
	
	
	
	
	public List<Recus> findAllRecus (){
		return repository.findAll();
	}
	
	public void readFile(List blocks) throws ParseException {
		
		// create recu 
		Recus recu = new Recus();
		// extract ID 
		recu.setId(blocks.get(0).toString().substring(blocks.get(0).toString().length()-11, blocks.get(0).toString().length()-1)); 
		
		recu.setType(Integer.parseInt(blocks.get(1).toString().substring(1, 4)));
		
		recu.setSens(blocks.get(1).toString().substring(0,1));
		
		recu.setRec(blocks.get(1).toString().substring(14,26));
		
		recu.setEme(blocks.get(0).toString().substring(3,15));
		
		String dateStr = blocks.get(1).toString().substring(blocks.get(1).toString().length()-12,blocks.get(1).toString().length()-6);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		recu.setDateRec(dateFormat.parse(dateStr));
		
		
		recu.setTimeRec(blocks.get(1).toString().substring(blocks.get(1).toString().length()-6,blocks.get(1).toString().length()-2));
		
		// creation détails 
		Detail detail1 = new Detail();
		detail1.setId(recu.getId());
		// creation list of tags 
		List<TagRecus> listTag = new ArrayList<>();
		String tags = blocks.get(3).toString().substring(0, blocks.get(3).toString().length()-1)+":";
		
		// extract tags 
		String[] parts = tags.split(":");
		
		TagRecus tagI = new TagRecus();
		for (int i = 1; i< parts.length; i+= 1) {
			
			if (i % 2 == 0) {
				tagI.setValeur(parts[i]);
				listTag.add((i / 2) -1, tagI);   
				tagRepositories.save(tagI);
				tagI = new TagRecus();
				
				
			}else {
				
				tagI.setTag(parts[i]);
				int order =  ConstantsTag.tags.indexOf(parts[i].toLowerCase());
				if (order == -1 ) {
					order =  ConstantsTag.tags.indexOf(parts[i].toUpperCase());
				}
				tagI.setOrdre(order+1);		
				
			}
		}
		
		detail1.setTagRecus(listTag);
		
        detailRepositorie.save(detail1);
        
        recu.setDetail(detail1);
        repository.save(recu);
		
		
	}
	
	
	

}
