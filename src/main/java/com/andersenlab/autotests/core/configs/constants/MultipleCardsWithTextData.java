package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class MultipleCardsWithTextData {
    public enum EnterpriseCompetitorsChoose{
        HEADER("Why your competitors choose Andersen", "", ""),
        FIRST("Extensive industry knowledge",
                "According to Online Learning Consortium, the proportion of students enrolled in online courses exceeds 25% of the total number of trainees and continues to increase. Therefore, we are implementing the key principles of ID to maximize the involvement of students of all age groups and levels of training.",
                SvgIcons.featureSuccess),
        SECOND("Cross-industry expertise",
                "Every year we confirm our high qualifications by building eCommerce applications for such industries as Healthcare, FinTech, TelCo, Supply Chain. In order for you to be head and shoulders above your competitors, our developers also introduce AR and VR in eCommerce products using the latest IoT achievements to build a new buying experience.",
                SvgIcons.featureSuccess),
        THIRD("Transparent projects",
                "Scrum / Kanban methodologies applied by our engineers provide the possibility of high development speed and project flexibility. Daily communication with the team ensures complete control over the work progress at each stage of product development.",
                SvgIcons.featureSuccess),
        FOURTH("Excellent code quality",
                "Our code meets CISQ requirements by default, which means that by ordering eCommerce development, you receive a secure, reliable, scalable, and easily maintainable solution.",
                SvgIcons.featureSuccess);
        @Getter final private String title;
        @Getter final private String message;
        @Getter final private String imageLink;
        EnterpriseCompetitorsChoose(String title, String message, String imageLink){
            this.title = title;
            this.message = message;
            this.imageLink = imageLink;
        }
    }

    public enum TelecomReliableSolutions{
        HEADER("Reliable telecom solutions for complicated problems",
                "Creation and configuration of the infrastructure for the telecommunications business include the development of specialized applications and protocols, uniting them into a single software and hardware complex. Andersen solves dozens of such tasks annually, providing customers with the best means to achieve their business goals:", ""),
        FIRST("Easy-to-use communication tools",
                "Regardless of whether you need to launch a teleconference between New York and Sydney, ensure reliable voice communication for your users, or create a video conference with hundreds of people, we will provide cloud collaboration solutions that support VoIP, SRTP, multiple languages, and API.",
                "#fingers"),
        SECOND("Advanced control",
                "Telecommunication companies can lose up to 20% of profits due to failures in the software and hardware complex. In order to help you avoid this, we create IoT-based systems that monitor network performance 24/7 and automatically generate fault reports.",
                "#gears"),
        THIRD("Improved communication quality",
                "We integrate telecommunications software with Windows/ macOS/Linux-based computers, mobile iOS and Android devices, including phones and tablets. Any solution containing audio and streaming video can be optimized to remain stable regardless of your Internet speed. As a result, clients can use your services anywhere and at any time.",
                "#communication"),
        FOURTH("Increased operational security",
                "Like other telecom software companies, we develop software in compliance with International Telecommunication Union standards. Besides, Andersen integrates intrusion detection AI algorithms and such data encryption algorithms as NASH, AES, DES, RSA, El-Gamal into your solutions. Combined with the PCI DSS standard to protect online payments, this ensures complete data security for both you and your users.",
                "#security");
        @Getter final private String title;
        @Getter final private String message;
        @Getter final private String imageLink;
        TelecomReliableSolutions(String title, String message, String imageLink){
            this.title = title;
            this.message = message;
            this.imageLink = imageLink;
        }
    }

    public enum TelecomWhyAndersen{
        HEADER("Why Andersen",
                "", ""),
        FIRST("Deep understanding of the industry",
                "Our solutions for mobile operators are compliant with 3GPP standards. Wireless technology software is compliant with IEEE 802.11 standards. When ordering an application for the Future Internet, you can be sure it will be compliant with IETF recommendations.",
                SvgIcons.featureSuccess),
        SECOND("Transparent processes",
                "A flexible approach to development using the SCRUM methodology ensures that all processes at any stage of the SDLC will be clear to the customer, and making changes to the product will not require a long approval process.",
                SvgIcons.featureSuccess),
        THIRD("High software performance",
                "Andersen’s engineers with an average experience of more than 7 years have been creating robust and scalable applications that can handle millions of requests per second.",
                SvgIcons.featureSuccess),
        FOURTH("Full range of services",
                "We not only write programs but also explore your market and users before starting development. Thus we can guarantee that we create the best solutions for your business.",
                SvgIcons.featureSuccess);
        @Getter final private String title;
        @Getter final private String message;
        @Getter final private String imageLink;
        TelecomWhyAndersen(String title, String message, String imageLink){
            this.title = title;
            this.message = message;
            this.imageLink = imageLink;
        }
    }

    public enum TelecomServices{
        HEADER("Telecom software development services",
                "A full range of professional Telecom software development services to fulfill your business goals and ensure the exceptional quality of your product.",
                ""),
        FIRST("Consulting",
                        "Documentation\n" +
                        "Budgeting\n" +
                        "UI/UX design\n" +
                        "Quality Assurance\n" +
                        "Marketing",
                SvgIcons.bankingAndConsumer),
        SECOND("Development",
                        "Project management\n" +
                        "Business analysis\n" +
                        "UI/UX design\n" +
                        "Engineering\n" +
                        "Quality assurance",
                SvgIcons.capitalMarkets),
        THIRD("Maintenance & Support",
                               "Platform maintenance\n" +
                               "L1, L2, L3 support\n" +
                               "Performance optimization\n" +
                               "Customer support\n" +
                               "Digital transformation",
               SvgIcons.insurance);
        @Getter final private String title;
        @Getter final private String message;
        @Getter final private String imageLink;
        TelecomServices(String title, String message, String imageLink){
            this.title = title;
            this.message = message;
            this.imageLink = imageLink;
        }
    }

    public enum RealEstateBenefits{
        HEADER("Check out the benefits of custom real estate software by Andersen",
                "Take a look at the advantages of our real estate software development services that will help you become a leader in this highly competitive sphere:",
                ""),
        FIRST("Commercial property",
                "Broad opportunities for increasing the base of potential clients through integration with Google, Bing, and Yahoo marketing systems\n" +
                        "Effective channels for communication with tenants via specialized messenger apps and web portals\n" +
                        "Real-time financial performance tracking with the help of inline analytics and data visualization\n" +
                        "Facilities management in real time mode with the help of easy-to-use CMS",
                SvgIcons.featureSuccess),
        SECOND("Housing property",
                "Enhanced security level and easy access to real estate with the help of an intelligence system of access rights distribution\n" +
                        "Maximum customer satisfaction with available resources using resource booking applications\n" +
                        "Timely maintenance of houses and flats driven by smart sensors monitoring the state of property units\n" +
                        "Saving time through automation of routine processes - from mailing to report generation",
                SvgIcons.featureSuccess);
        @Getter final private String title;
        @Getter final private String message;
        @Getter final private String imageLink;
        RealEstateBenefits(String title, String message, String imageLink){
            this.title = title;
            this.message = message;
            this.imageLink = imageLink;
        }
    }

    public enum RealEstateWhatWeSuggest{
        HEADER("What we suggest:",
                "All real estate software development companies try to offer solutions that open new opportunities for increasing revenue. Andersen uses VR / AR technologies, machine learning, artificial intelligence, and IoT to outreach the expected result by establishing stronger relations with your customers.",
                ""),
        FIRST("Real estate management software",
                "Websites, applications for iOS and Android, their integration with Salesforce, PropertyBase, BrokerMind, AppFolio, Revel platforms as well as Virtual office websites (VOW) and Value management services (VMS), security systems, custom CRM, SQL server reporting services.",
                SvgIcons.featureSuccess),
        SECOND("Software for real estate evaluation",
                "Custom solutions for real estate evaluation and cost forecasts using Big Data. Creation of separate models with inline analytics or integration of your products with ready-made solutions, including Real Capital Analytics, CoreLogic, Terradatum, Alteryx.",
                SvgIcons.featureSuccess),
        THIRD("MLS software",
                "Development of custom MLS platforms and their integration with existing multiple listing services, such as Zillow, Trulia, HomeFinder, Homes, Redfin, ZipRealty, and RealtyTrac.",
                SvgIcons.featureSuccess),
        FOURTH("Solutions for HOA",
                "Cloud or mobile software for automation of accounting and optimization of processes within the HOA, extensions for online payments, applications for communication between residents.",
                SvgIcons.featureSuccess),
        FIFTH("IDX solutions",
                "Development of custom Internet data exchange applications and integration of off-the-shelf solutions with existing IDX in accordance with the National Association of Realtors’ (NAR) requirements.",
                SvgIcons.featureSuccess),
        SIXTH("Software for property management",
                "Products for real estate owned property management (REO), program modules for automation of interaction with tenants and tax authorities, aggregation of property state related data in real time.",
                SvgIcons.featureSuccess);
        @Getter final private String title;
        @Getter final private String message;
        @Getter final private String imageLink;
        RealEstateWhatWeSuggest(String title, String message, String imageLink){
            this.title = title;
            this.message = message;
            this.imageLink = imageLink;
        }
    }

    public enum RetailCustomSoftDev{
        HEADER("Custom software development for retail",
                "A wide range of professional retail software development services to increase your sales and improve your management process",
                ""),
        FIRST("Retail software development",
                "Development of custom retail software solutions designed to improve both business processes and customer experience to let your enterprise prosper.",
                SvgIcons.displayTag),
        SECOND("Customization of retail software",
                "Adjustment, integration, and improvement of the existing ready-made software products so that they perfectly meet the requirements of your business.",
                SvgIcons.andersenMobile),
        THIRD("Third-party systems integration",
                "Integration of the developed software with ERP, sales channels, eCommerce platforms, shipping services, payment systems, and other third-party solutions.",
                SvgIcons.cart);
        @Getter private final List<String> data;

        RetailCustomSoftDev(String title, String subtitle, String image){
            this.data = Arrays.asList(title, subtitle, image);
        }

    }

    public enum HealthcareWhyCustomersChooseAndersen{
        HEADER("Why Healthcare Companies Choose Andersen",
                "Andersen has deep expertise in digitalizing every aspect of the healthcare value chain. Grow your revenue by adding a partner that’s aligned with your success. Leverage Andersen’s expertise, network, technology, and data-driven insights, and surpass your goals",
                ""),
        FIRST("Expertise in healthcare",
                "For over 14 years, healthcare businesses have been powered by Andersen’s digital solutions. With the help of AI, IoMT, and data-driven applications, Andersen creates a technology foundation for care providers, payers, pharmacies, PBMs and healthcare software vendors in their mission to save lives and nurture health.",
                "#hands-and-reward"),
        SECOND("Focus on usability",
                "Medical specialization-specific UX and UI expertise. Clean, uncluttered interfaces designed for efficiency. Disability-conscious design for patient-facing systems.",
                "#hand-and-structure"),
        THIRD("Interoperability",
                "Andersen makes it possible to follow care across different settings, with all of the relevant information you need in easy reach. Seamless integration of custom applications with installed third-party systems, whether it's an EHR, PACS, HIE, or claim management systems.",
                "#puzzle"),
        FOURTH("Improved efficiency",
                "With expert back-office teams and automation, Andersen takes on your administrative work - at speed, at scale, and more efficiently than any one organization possibly could - so you can focus on the higher-value work you went into healthcare to do.",
                "#laptop-with-arrow-up"),
        FIFTH("Information security",
                "Andersen guarantees the stability of clinical trial management and EHR systems against digital threats and attacks ensuring an increased level of security and healthcare regulatory compliance (HIPPA, HITECH, SSAE).",
                "#hand-info-security"),
        SIXTH("Best value for money",
                "Most healthcare software costs more than the price tag suggests - and delivers far less than promised. Andersen is an investment that drives returns.",
                "#graph-dollar");
        @Getter final private List<String> data;
        HealthcareWhyCustomersChooseAndersen(String title, String message, String imageLink){
            this.data = Arrays.asList(title, message, imageLink);
        }
    }
}