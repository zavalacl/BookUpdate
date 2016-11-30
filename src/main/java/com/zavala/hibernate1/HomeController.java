package com.zavala.hibernate1;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		//get the list of books from DAO
		List<Book> books = DAO.getAllBooks();
		
		//add this list to the model
		model.addAttribute("bookList", books );
		
		return "list";
		
	}
	
	@RequestMapping(value = "/bookEntry", method = RequestMethod.GET)
	public String bookEntry(Model model, HttpServletRequest request) {
		Book book = new Book();
		
		//get the entered book data from DAO
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		book.setPublisher(request.getParameter("publisher"));
		book.setImprint(request.getParameter("imprint"));
		book.setSales(Integer.valueOf(request.getParameter("sales")));
		book.setYearPublished(Integer.valueOf(request.getParameter("yearPub")));
		book.setGenre(request.getParameter("genre"));
		book.setStatus(Integer.valueOf(request.getParameter("status")));
		book.setBorrower(Integer.valueOf(request.getParameter("borrower")));

		book.setRank(DAO.addBook(book));
		
		//add new book to the model
		model.addAttribute("nb", book );
		
		return "bookEntry";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteBook(Model model, HttpServletRequest request, @RequestParam(value="rank") int rank){
		
		DAO.deleteBook(rank);
		return "deleteBook";
	}
	
}
