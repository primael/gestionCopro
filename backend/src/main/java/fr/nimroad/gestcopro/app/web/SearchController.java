package fr.nimroad.gestcopro.app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nimroad.gestcopro.app.solr.service.CoproprietaireService;

@Controller
@Component
@Scope("prototype")
public class SearchController {

	private CoproprietaireService coproprietaireService;

	@RequestMapping("/search")
	public String search(Model model, @RequestParam(value = "q", required = false) String query,
			@PageableDefault(page = 0, size = CoproprietaireService.DEFAULT_PAGE_SIZE) Pageable pageable,
			HttpServletRequest request) {

		model.addAttribute("page", coproprietaireService.findByName(query, pageable));
		model.addAttribute("pageable", pageable);
		model.addAttribute("query", query);
		return "search";
	}

	@Autowired
	public void setCoproprietaireService(CoproprietaireService coproprietaireService) {
		this.coproprietaireService = coproprietaireService;
	}
	
	
}
