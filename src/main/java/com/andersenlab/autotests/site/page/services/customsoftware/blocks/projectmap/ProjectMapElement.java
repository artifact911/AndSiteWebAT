package com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ProjectMapElement implements ProjectMapLocators{
    private final SelenideElement Title = $(TITLE);
    private final SelenideElement SubTitle = $(SUBTITLE);
    private final ElementsCollection ButtonsFilter = $$(BUTTONS_FILTER);
    private final ElementsCollection Points = $$(POINTS);
    private final SelenideElement GoogleTerms = $(GOOGLE_LINK);
    private final SelenideElement ProjectsCount = $(PROJECTS_COUNT);
    private final SelenideElement ContainerModal = $(MODAL_CONTAINER);
    private final ElementsCollection ModalAccordionElements = $$(MODAL_ACCORDION_ELEMENTS);
    private final ElementsCollection ModalCVExamples = $$(MODAL_CV_EXAMPLES);
    private final SelenideElement MapPlusBtn = $(MAP_PLUS_BTN);
    private final SelenideElement MapMinusBtn = $(MAP_MINUS_BTN);
    private final SelenideElement ButtonViewCase = $(MODAL_VIEW_CASE_BTN);
    private final SelenideElement ButtonSeeReference = $(BUTTON_SEE_REFERENCE);
    private final SelenideElement ButtonCloseModal = $(BUTTON_CLOSE_MODAL);
    private final SelenideElement SliderControlModule = $(SLIDER_CONTROL_MODULE);
    private final SelenideElement SliderButtonPrevious = $(SLIDER_BUTTON_PREVIOUS);
    private final SelenideElement SliderButtonNext = $(SLIDER_BUTTON_NEXT);
    private final ElementsCollection Projects = $$(PROJECTS);
    private final ElementsCollection ProjectLinks = $$(PROJECT_LINKS);
    private final ElementsCollection ProjectLogos = $$(PROJECT_LOGOS);
    private final ElementsCollection ProjectTitles = $$(PROJECT_TITLES);
    private final SelenideElement PricingModule = $(PRICING_MODULE);
    private final SelenideElement PricingModuleContent = $(PRICING_MODULE_CONTENT);
    private final SelenideElement PricingModuleButton = $(PRICING_MODULE_BUTTON);
}
