package com.example.demo.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Services.RecusService;
import com.example.demo.models.Recus;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/recuApp")
public class RecuController {

	@Autowired
	private RecusService service ;
	
	
	
	
	@GetMapping("getAll")
	public List<Recus> findAllRecus() {
		return service.findAllRecus();
	}
	
	@PostMapping("read-Mt103")
	public void readMt103(@RequestParam("file") MultipartFile file) throws ParseException {
		try {
			
			InputStream inputStream = file.getInputStream();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	        List<String> lines = new ArrayList<>();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Process each line of the file
	            lines.add(line);
	        }

	        reader.close();
	        inputStream.close();
	        
			//List<String> lines = Files.readAllLines(Paths.get("src/main/resources/Mt103.txt"));
			//file.addAttribute("lines", lines);
			String textMt103 = "";
			for (String element : lines) {
				textMt103 = textMt103 + element;
			}
			System.err.println("test test ");
			// extract block 5
		
			int startindex = textMt103.indexOf("{5:");
			String block5 = textMt103.substring(startindex + 3);
			//System.err.println("block 5 => "+block5);
			textMt103 = textMt103.substring(0, startindex);
		
			// extract block 4
			
			startindex = textMt103.indexOf("{4:");
			String Block4 = textMt103.substring(startindex + 3);
			//System.err.println("Block 4 => "+Block4);
			textMt103 = textMt103.substring(0, startindex);
			// extract block 3
			startindex = textMt103.indexOf("{3:");
			String Block3 = textMt103.substring(startindex + 3);
			//System.err.println("Block 3 => "+Block3);
			textMt103 = textMt103.substring(0, startindex);
			// extract block 2
			startindex = textMt103.indexOf("{2:");
			String Block2 = textMt103.substring(startindex + 3);
			//System.err.println("Block 2 => "+Block2);
			textMt103 = textMt103.substring(0, startindex);
			// extract block 1
			startindex = textMt103.indexOf("{1:");
			String Block1 = textMt103.substring(startindex + 3); 
			//System.err.println("Block 1 => "+Block1);
			
			List<String> blocks = new ArrayList<String>();
			blocks.add(Block1);
			blocks.add(Block2);
			blocks.add(Block3);
			blocks.add(Block4);
			blocks.add(block5);
			
			service.readFile(blocks);
			 
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/*@GetMapping("read-Mt103")
	public void readMt103(Model model) throws ParseException {
		try {
			List<String> lines = Files.readAllLines(Paths.get("src/main/resources/Mt103.txt"));
			model.addAttribute("lines", lines);
			String textMt103 = "";
			for (String element : lines) {
				textMt103 = textMt103 + element;
			}
			
			// extract block 5
		
			int startindex = textMt103.indexOf("{5:");
			String block5 = textMt103.substring(startindex + 3);
			//System.err.println("block 5 => "+block5);
			textMt103 = textMt103.substring(0, startindex);
		
			// extract block 4
			
			startindex = textMt103.indexOf("{4:");
			String Block4 = textMt103.substring(startindex + 3);
			//System.err.println("Block 4 => "+Block4);
			textMt103 = textMt103.substring(0, startindex);
			// extract block 3
			startindex = textMt103.indexOf("{3:");
			String Block3 = textMt103.substring(startindex + 3);
			//System.err.println("Block 3 => "+Block3);
			textMt103 = textMt103.substring(0, startindex);
			// extract block 2
			startindex = textMt103.indexOf("{2:");
			String Block2 = textMt103.substring(startindex + 3);
			//System.err.println("Block 2 => "+Block2);
			textMt103 = textMt103.substring(0, startindex);
			// extract block 1
			startindex = textMt103.indexOf("{1:");
			String Block1 = textMt103.substring(startindex + 3); 
			//System.err.println("Block 1 => "+Block1);
			
			List<String> blocks = new ArrayList<String>();
			blocks.add(Block1);
			blocks.add(Block2);
			blocks.add(Block3);
			blocks.add(Block4);
			blocks.add(block5);
			
			service.readFile(blocks);
			 
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
	}*/
}
