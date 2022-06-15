package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class FeaturesIndexBlockData {
    public enum Left {
        REAL_ESTATE(Arrays.asList("Transforming the analog real estate business into a digital one",
                "For over 10 years, we have been creating custom real estate software for property owners, tenants, investors, builders, real estate developers, architects, banks, and leasing companies.",
                SvgIcons.skyscraper,
                "Request consultation")),
        TELECOM(Arrays.asList("Get innovative custom Telecom software to propel your digital transformation",
                "",
                SvgIcons.telecom,
                "Request Consultation")),
        IGAMING(Arrays.asList("Call your iGaming ideas into play with an expert in-house team of software developers",
                "",
                SvgIcons.dice,
                "Request consultation")),
        IGAMING_PLATFORM(Arrays.asList("Build your iGaming Platform from scratch or boost an already existing solution with an in-house team of experts.",
                "",
                SvgIcons.dice,
                "Request consultation")),
        IGAMING_BETTING(Arrays.asList("Your ideas is the beginning of the road. We take care of the rest.",
                "",
                SvgIcons.dice,
                "Request consultation")),
        LOGISTICS(Arrays.asList("Succeed in the digital transformation of your business with our range of software development services ",
                "",
                SvgIcons.geometricFigures,
                "Request consultation")),
        ENTERPRISE(Arrays.asList("Increase your business agility and efficiency with custom enterprise applications",
                SvgIcons.lampArrow,
                "",
                "Request consultation")),
        RETAIL(Arrays.asList("Fuel your business with the robust retail software built by a trusted development house",
                "",
                SvgIcons.cart,
                "Request consultation")),
        VIDEOENTERTAINMENT(Arrays.asList("Get the most from the digital transformation in Multimedia and Entertainment in your business",
                "",
                SvgIcons.playCircle,
                "Request consultation")),
        HEALTHCARE(Arrays.asList("Healthcare software development company with proven expertise",
                "",
                SvgIcons.healthcareHeart,
                "Request consultation")),
        EMR(Arrays.asList("Drive better clinical, financial and operational outcomes with responsible, secure and affordable EMR solutions",
                "",
                SvgIcons.healthcareHeart,
                "Request consultation")),
        DATA_ANALYTICS_AND_IOMT(Arrays.asList("Leverage Healthcare data solutions to improve patient care, reduce costs, and maximize revenue of your business",
                "",
                SvgIcons.healthcareHeart,
                "Request consultation")),
        TELEHEATH(Arrays.asList(
                "Get advantage of custom Telemedicine software solutions to deliver your health services remotely",
                "",
                SvgIcons.healthcareHeart,
                "Request consultation")),
        HEALTHCARE_SOFT_DEV(Arrays.asList(
                "A complete range of Custom Healthcare Software to drive digital transformation of your business",
                "",
                SvgIcons.healthcareHeart,
                "Request consultation")),
        TRAVEL_AND_HOSPITALITY(Arrays.asList(
                "Build robust software to meet the changing requirements and unique needs of your business",
                "",
                SvgIcons.bagTravel,
                "Request consultation"));

        @Getter private final List<String> data;
        Left(List<String> data){
            this.data = data;
        }
    }
    public enum Right {
        REAL_ESTATE(Arrays.asList(
                Arrays.asList("PROFESSIONAL SOLUTIONS",
                        "In order to build Property Management Software Solutions for our customers, we engage developers with an average experience of 7+ years, CBAP-certified analysts, ISTQB QA specialists.",
                        "finished projects"),
                Arrays.asList("HIGH QUALITY",
                        "Data-based approach, as well as full compliance of our solutions with the RETS, PCI-DSS, PA-DSS standards and Sarbanes-Oxley Act, convinces customers of the quality of our software.",
                        "satisfied clients"),
                Arrays.asList("TRUSTWORTHY GUARANTEE",
                        "Before the release of our solutions, we check the code quality both manually and with the help of software tools, thus eliminating serious bugs.",
                        "months guarantee"))),
        TELECOM(Arrays.asList(
                Arrays.asList("RICH EXPERIENCE",
                        "For 14 years, Andersen has been delivering effective software solutions for businesses to help them benefit from technology, reduce operational costs, and provide a high-quality level of service",
                        "delivered projects"),
                Arrays.asList("CERTIFIED ENGINEERS",
                        "The high-quality standard is ensured by our developers with CCNT, CTNS, IPEP, RCDD certificates, CBAP-compliant Business Analysts, and ISTQB-certified QA engineers",
                        "telecom experts"),
                Arrays.asList("STABILITY ASSURANCE",
                        "Andersen delivers reliable software, monitors network performance 24/7, and automatically generates fault reports to ensure the stability of your project",
                        "months guarantee"))),
        IGAMING(Arrays.asList(
                Arrays.asList("RELIABLE SOLUTIONS",
                        "Working with businesses of all sizes, Andersen provides complex solutions designed to achieve your goals with impactful, industry-specific, and revenue-generating software solutions",
                        "years"),
                Arrays.asList("FULL INDUSTRY COVERAGE",
                        "Working with iGaming platforms, game providers, and game development studios",
                        "projects"),
                Arrays.asList("EXPERT TEAM",
                        "Great experts team power solution development and transformation from scratch to release",
                        "industry experts"))),
        IGAMING_PLATFORM(Arrays.asList(
                Arrays.asList("EXPERIENCE IN CUSTOM_IGAMING_SOFTWARE_DEVELOPMENT",
                        "Extensive experience in custom software development and deep expertise in developing solutions for the iGaming industry",
                        "years of experience"),
                Arrays.asList("TRUSTED COMPANY",
                        "Technical knowledge and organized, experienced teams result in a well-designed platform that will increase your business’ efficiency and GGR",
                        "projects"),
                Arrays.asList("PROVEN EXPERTISE",
                        "Deploy the most engaging gaming experience with an award winning UI/UX design studio",
                        "winning awards"))),
        IGAMING_BETTING(Arrays.asList(
                Arrays.asList("PROVEN ACKNOWLEDGEMENT",
                        "Andersen iGaming solutions are recognised all over the globe and unite millions of users",
                        "users worldwide"),
                Arrays.asList("TEAM OF EXPERTS",
                        "Sports Betting software developers power the digital transformation of the industry to evolve your business to the next level",
                        "industry experts"),
                Arrays.asList("EXPERIENCE IN CUSTOM_IGAMING_SOFTWARE_DEVELOPMENT",
                        "Extensive experience in custom software development and deep expertise in developing solutions for the iGaming industry",
                        "years of experience"))),
        LOGISTICS(Arrays.asList(
                Arrays.asList("CONSIDERABLE EXPERIENCE",
                        "Andersen transforms businesses with the help of custom software solutions that are effective today and provide opportunities for development in the future",
                        "years of experience"),
                Arrays.asList("RELIABLE EXPERTS",
                        "In-house teams of IT specialists have tailored their logistics and supply chain expertise in dozens of projects",
                        "qualified specialists"),
                Arrays.asList("EXTENSIVE EXPERIENCE",
                        "We contribute to custom logistics software development for multiple businesses across the globe like FedEx Ground, Nexxiot, and OurCNC.",
                        "successful projects"))),
        ENTERPRISE(Arrays.asList(
                Arrays.asList("FLAWLESS TRACK RECORD",
                        "Andersen’s team has successfully delivered multiple complex projects for manufacturing enterprises",
                        "years of experience"),
                Arrays.asList("IT TALENT WITH ENTERPRISE EXPERIENCE",
                        "Andersen’s IT talent pool is made up of skilled and experienced industry experts. Most of them have taken part in large enterprise software development projects",
                        "enterprise experts"),
                Arrays.asList("CUSTOMER LOYALTY",
                        "Enterprise customers appreciate our approach and the software projects delivered. As a result, most of them partner with us on a long-term basis",
                        "long-term projects"))),
        RETAIL(Arrays.asList(
                Arrays.asList("EXTENSIVE EXPERIENCE",
                        "Andersen has been engaged in retail software development for over a decade and has delivered more than 50 successful solutions within the industry.",
                        "years"),
                Arrays.asList("WORLDWIDE PRESENCE",
                        "Working with retail businesses across the globe and of any size, including companies from the TOP list of international Retailers.",
                        "customers"),
                Arrays.asList("TEAM OF PROFESSIONALS",
                        "The development is carried out by proven retail experts and certified IT specialists with solid experience in the industry.",
                        "specialists"))),
        VIDEOENTERTAINMENT(Arrays.asList(
                Arrays.asList("RELIABLE EXPERTS",
                        "In-house teams of IT specialists have tailored their Multimedia and Entertainment expertise in dozens of projects.",
                        "qualified specialists"),
                Arrays.asList("VIABLE SOLUTIONS",
                        "Our portfolio includes long-lasting relations and impressive cases for companies like Samsung, Marvel, Rostelecom, IVI, and more.",
                        "successful projects"),
                Arrays.asList("CONSIDERABLE EXPERIENCE",
                        "Since our founding in 2007, we've launched over 130 projects, continuously improving and growing with our clients and experts",
                        "years of experience"))),
        HEALTHCARE(Arrays.asList(
                Arrays.asList(
                        "CUSTOM HEALTHCARE SOFTWARE",
                        "Thousands of hours spent on the implementation of patient engagement portals, certified EHRs, healthcare data analytics tools, telehealth and more",
                        "delivered projects"),
                Arrays.asList(
                        "HEALTHCARE DEVELOPERS YOU CAN TRUST",
                        "Healthcare Data scientists, HCISPP-certified managers, AWS engineers, HIMSS professionals work on your healthcare software solutions.",
                        "healthcare developers"),
                Arrays.asList(
                        "RELIABLE HEALTHCARE SOLUTIONS",
                        "Medical software development is not a sphere that is tolerant of missteps. We guarantee that you will receive a reliable solution and provide 24/7 support after release.",
                        "month guarantee"))
        ),
        DATA_ANALYTICS_AND_IOMT(Arrays.asList(
                Arrays.asList(
                        "EXPERIENCED HEALTHCARE DATA ENGINEERS",
                        "Our healthcare data scientists and data analysts have years of experience in the healthcare industry.",
                        "years in business"),
                Arrays.asList(
                        "HIPAA/GDPR COMPLIANT SOLUTIONS",
                        "Contact us any time with queries regarding your medical or healthcare data outsourcing needs.",
                        "support"),
                Arrays.asList(
                        "HEALTHCARE DATA QUALITY CONTROL",
                        "Quality assurance programs applied on all projects to ensure accuracy, consistency and relevancy of healthcare data.",
                        "accuracy"))
        ),
        EMR(Arrays.asList(
                Arrays.asList(
                        "EXPERIENCE IN HEALTHCARE",
                        "Hundreds of hours spent on the implementation of HIPAA, HITECH, SSAE standards, dozens of applications for doctors and patients, custom CRM-systems.",
                        "years of experience"),
                Arrays.asList(
                        "INFORMATION SECURITY",
                        "Andersen guarantees the stability of clinical trial management and EHR systems to digital threats and attacks ensuring increased level of security and healthcare regulatory compliance.",
                        "successful projects"),
                Arrays.asList(
                        "IMPROVED EFFICIENCY",
                        "With expert back-office teams and automation, Andersen takes on your administrative work so you can focus on the higher-value work you went into healthcare to do.",
                        "data integration"))
        ),
        TELEHEATH(Arrays.asList(
                Arrays.asList(
                        "EXPERIENCED TELEMEDICINE DEVELOPERS",
                        "Our telemedicine development teams deliver custom telemedicine solutions for primary/secondary care and urgent care providers.",
                        "healthcare developers"),
                Arrays.asList(
                        "TELEMEDICINE PRIVACY AND SECURITY",
                        "Our custom EHR and EMR solutions adhere to HIPAA/GDPR regulations by utilizing secure messaging and encrypted file transfer protocols.",
                        "GDPR and HIPAA compliant"),
                Arrays.asList(
                        "ADVANCED TELECOMMUNICATION TOOLS",
                        "Andersen’s telemedicine solutions are built around modern communication protocols and APIs to provide maximum quality of remote engagement.",
                        "years of experience"))
        ),
        HEALTHCARE_SOFT_DEV(Arrays.asList(
                Arrays.asList(
                        "YEARS OF HEALTHCARE DEVELOPMENT",
                        "Thousands of hours spent on the implementation of patient engagement portals, certified EHRs, healthcare data analytics tools, telehealth and more",
                        "years of experience"),
                Arrays.asList(
                        "HEALTHCARE DEVELOPERS YOU CAN TRUST",
                        "With Andersen, you don't merely get a healthcare software developer, you get a reliable business partner",
                        "customer satisfaction"),
                Arrays.asList(
                        "VALUE FOR MONEY HEALTHCARE SOFTWARE",
                        "Most healthcare software costs more than the price tag suggests - and delivers far less than promised. Andersen is an investment that drives returns",
                        "ROI on most projects"))
        ),
        TRAVEL_AND_HOSPITALITY(Arrays.asList(
                Arrays.asList(
                        "LONG-STANDING EXPERIENCE",
                        "Andersen’s team develops scalable and efficient Travel & Hospitality software solutions, from effective mobile applications to complex custom-made systems",
                        "years of experience"),
                Arrays.asList(
                        "TOP-NOTCH SPECIALISTS",
                        "Andersen provides you with cloud-certified engineers working with the Booking.com API connection and consultants meeting the CBAP requirements",
                        "industry experts"),
                Arrays.asList(
                        "CROSS-FUNCTIONAL COMPATIBILITY",
                        "Andersen’s products are compliant with Hotel Technology Next Generation (HTNG) and Open Payments Alliance (OPA) standards, and are fully integrated with 3rd-party services",
                        "finished projects"))
        );
        @Getter private final List<List<String>> data;
        Right(List<List<String>> data){
            this.data = data;
        }
    }
}
