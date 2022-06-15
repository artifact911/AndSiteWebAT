package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AdvisoryBlockData {
    public enum Healthcare{
        BLOCK(Arrays.asList(
                "Advisory board",
                "Our medical board includes over 30 clinicians, researchers and experts from Europe and North America as well as in-house healthcare professionals")),
        FIRST(Arrays.asList(
                "/consultants/Doroty-N-Monekosso.png",
                "https://www.linkedin.com/in/prof-dorothy-monekosso",
                "Dorothy N. Monekosso",
                "Professor of computer science, UK",
                "Dorothy Monekosso is a British academic. She is Professor of Computer Science in the School of Built Environment, Engineering and Computing at Leeds Beckett University. Her research interests include assistive and rehabilitation technologies, smart environments and smart homes to support independent living.")),
        SECOND(Arrays.asList(
                "/consultants/Dirk-Huske-Kraus.png",
                "https://www.linkedin.com/in/dr-dirk-h%C3%BCske-kraus-b9142a13",
                "Dirk Hüske-Kraus",
                "Director Professional Services Innovation at Philips",
                "Dirk Hüske-Kraus is Director Professional Services Innovation at Philips HealthTech – global leader in diagnostic imaging, patient monitoring, health informatics, consumer health and home care. Dr. Hüske-Kraus is a clinical consulting and education professional with 30+ years experience in Healthcare IT and Expertise in Natural Language Generation in clinical medicine. Part-time lecturer at Furtwangen University.")),
        THIRD(Arrays.asList(
                "/consultants/David-Morgan.png",
                "https://www.linkedin.com/in/david-morgan-561b8719",
                "David Morgan",
                "Medical Director, Consultant Surgeon and Associate Professor",
                "Medical Director in company elaborating AI-based solutions in military pre-hospital care. Consultant Surgeon at Birmingham Heartlands Hospital and Associate Professor at the Clinical Research Institute, University of Warwick. Dr. Morgan is one of pioneers of AI-based solutions in healthcare, several times awarded by UK National Health System including Global Digital Exemplar (2018)."));
        @Getter private final List<String> data;
        Healthcare(List<String> data){
            this.data = data;
        }
    }
}
