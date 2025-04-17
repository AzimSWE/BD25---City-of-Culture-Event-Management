-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2025 at 09:23 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd25events2.0`
--

-- --------------------------------------------------------

--
-- Table structure for table `bd25events2.0`
--

CREATE TABLE `bd25events2.0` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `date` text NOT NULL,
  `organiser` text NOT NULL,
  `location` text NOT NULL,
  `target audience` text NOT NULL,
  `pricings` text NOT NULL,
  `description` text NOT NULL,
  `website link` text NOT NULL,
  `image link` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bd25events2.0`
--

INSERT INTO `bd25events2.0` (`id`, `name`, `date`, `organiser`, `location`, `target audience`, `pricings`, `description`, `website link`, `image link`) VALUES
(1001, 'Nationhood: Memory and Hope\r\n\r\n', '11TH January – 26th April 2025\r\n\r\n', 'Aida Muluneh \r\n', 'Impressions gallery = Bradford\r\nExposed = Belfast\r\nFfotogallery = Cardiff\r\nStreet level photoworks = Glasgow \r\n\r\n', 'Younger population and local heroes \r\n\r\n', 'free\r\n', 'outstanding collection of new photography celebrating the diversity of the UK in 2025.\r\n\r\n', 'https://bradford2025.co.uk/event/nationhood-memory-and-hope/\r\n\r\n', 'https://itsoninbradford.co.uk/wp-content/uploads/2024/09/Aida-Muluneh-Nationhood-Web-Header-3-1024x683.jpg\r\n\r\n'),
(1002, 'Fighting to be heard\r\n', '17th January – 27th April 2025\r\n\r\n', 'British library \r\n', 'Cartwright hall art gallery\r\n\r\n', 'Muslim community and men \r\n\r\n', 'free\r\n', 'This free exhibition explores connections between the two disciplines through the eyes of British south Asian Muslim men living in Bradford today. \r\n\r\n', 'https://bradford2025.co.uk/event/fighting-to-be-heard/\r\n\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/09/Screenshot-2025-04-03-at-10.40.25-600x311.png '),
(1003, 'Ramadan Pavillion \r\n \r\n', 'From 15th February 2025\r\n\r\n', 'Ramadan Tent Project\r\n', 'Centenery Square', 'Muslim community\r\n', 'free', 'The Ramadan Pavillion compromises of several arches that take inspiration from Bradford’s city hall. The Ramadan Pavillion will be lit up at sunset each day to mark the end of the fast (Iftar).\r\n', 'https://bradford2025.co.uk/event/ramadan-pavilion-2025/\r\n', 'https://images.adsttc.com/media/images/67c5/6efe/1b5d/5f01/86df/b21e/newsletter/bradford-unveils-ramadan-pavilion-infinite-light-for-2025-united-kingdom-city-of-culture_4.jpg?1740992282'),
(1004, 'I AM ME\r\n\r\n', '31st January – 15th May 2025\r\n', 'Bradford district museums and galleries\r\n', 'Cartwright hall art gallery\r\n', 'Young community\r\n\r\n', 'free', 'Bradford district museums and galleries and 125 young people from the district create a new exhibition with artworks from the government art collection.\r\n', 'https://bradford2025.co.uk/event/i-am-me/\r\n \r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/01/I-AM-ME-1080x1600.jpeg \r\n'),
(1005, 'David Hockney: Pieced together\r\n\r\n\r\n', '15th January – 18th May 2025\r\n\r\n', 'David Hockney \r\n\r\n', 'National science and media museum \r\n\r\n', 'Adult community\r\n\r\n', 'Free (pay as you feel) \r\n\r\n', 'Discover how David Hockney has pushed the boundaries of visual story telling through photography and digital techniques.\r\n\r\n', 'https://bradford2025.co.uk/event/david-hockney-pieced-together/\r\n', 'https://www.scienceandmediamuseum.org.uk/sites/default/files/styles/carousel/public/2024-11/hockney-joiner-nsmm-3.jpg?itok=-8NKHfbd \r\n'),
(1006, 'The DRAW! Tour: Workshops\r\n\r\n', '12th March – 28th March 2025\r\n\r\n', 'David Hockney\r\n', 'Venues across the Bradford district\r\n', 'Everyone is welcome (More aimed towards young people)\r\n', 'free', 'David Hockney has invited everyone to have a go at drawing this year. These DRAW! Tour: Workshops are a chance to join in with help on hand from local artists.\r\n\r\n', 'https://bradford2025.co.uk/event/the-draw-tour-workshops/\r\n\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/09/1248_Les-Girafes-Workshop-at-Allerton-Library_cPatrycja-Maziarz-600x400.jpg'),
(1007, 'Extraordinary portraits with Bill Bailey\r\n\r\n', '13th March – 6th April 2025\r\n \r\n', 'Bill Bailey alongside other local artists.\r\n\r\n', 'Loading Bay, Duke St\r\n\r\n', 'All ages\r\n\r\n', 'free\r\n', 'Get up close with artworks from the hit BBC One series at this exhibition in Loading Bay our new pop-up venue in Bradford. \r\n\r\n', 'https://bradford2025.co.uk/event/extraordinary-portraits/\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/01/DSCF0456-1600x1200.jpg \r\n'),
(1008, 'Dracula \r\n\r\n', '21st March – 23rd March 2025\r\n \r\n\r\n', 'Nick Lanes\r\n', 'Blackeyed Theatre\r\n', 'Ages 12+', '£17 \r\nYouth Pass = £5\r\nSeniors (60+) = £14\r\n\r\n', 'Victorian gothic atmosphere with 21st century attitude – Showcasing the ensemble performance in the Blackeyed Theatre. Haunting soundscapes, powerful performances and innovative design combine to create an exhilarating theatrical experience. Don’t get nightmares…\r\n', 'https://bradford2025.co.uk/event/dracula/\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/01/Dracula-Landscape-without-title-1600x893.jpg\r\n'),
(1009, 'Open Iftar\r\n\r\n', '21st & 22nd March 2025\r\n\r\n', 'Ramadan Tent Project ', 'One city park\r\n\r\n', 'Muslim Community\r\n', 'Free (Still need to book a ticket)\r\n', 'Come together, break your fast and share meals in a spirit of unity at these special community events, part of the Ramadan festival 2025, produced by the Ramadan Tent Project in Bradford.\r\n\r\n', 'https://bradford2025.co.uk/event/open-iftar/\r\n\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/02/Photo-Credit-Acacia-Diana-2-1600x1131.jpg'),
(1010, 'Bradford on foot\r\n\r\n', 'From April 2025\r\n\r\n', 'The routes are selected by historians, schoolchildren, artists and the people of the Bradford district.\r\n\r\n', 'All around the district \r\n\r\n', 'Outdoorsy community\r\n', 'free\r\n', 'Bradford on foot is a rich collection of 25 themed walks and tours around the 2025 city of culture’s secret or hidden gems and the great wide open.\r\n\r\n', 'https://bradford2025.co.uk/event/bradford-on-foot/\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/09/HAWORTH_BD25_SEP2024-74-600x400.jpg\r\n'),
(1011, 'Time for tea \r\n', '2nd April 2025 \r\n \r\n', 'Impressions gallery \r\n\r\n', 'Impressions gallery \r\n\r\n', 'Seniors (Over 60’s)\r\n\r\n', 'free', 'Enjoy tea and cake and a short talk about Nationhood: Memory at the impressions gallery’s free regular event for the over 60’s \r\n', 'https://bradford2025.co.uk/event/time-for-tea/\r\n\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/01/Nationhood-Time-for-Tea-Chris-Nunn-1600x1067.jpg \r\n'),
(1012, 'YOU: Matter \r\n\r\n', '3rd April 2025 – 28th February 2026 \r\n\r\n', 'Marshmallow laser feast \r\n\r\n', 'National Science and Media Museum \r\n\r\n', 'All ages \r\n\r\n', 'From £2\r\n\r\n', 'Take an unforgettable trip to discover our connection to the universe at the newly reopened National Science and Media Museum and understand the web of relationships that bond us all together – From the hairs on our heads to the stars in the sky. \r\n\r\n', 'https://bradford2025.co.uk/event/youmatter/\r\n\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/09/NSMM_YouMatter_Photography_250325_DSC01088-600x400.jpg'),
(1013, 'Bassline symphony \r\n\r\n', '9th May 2025\r\n\r\n', 'Arranger = Katie Chatburn\r\nCurator = Tanya Vital\r\n\r\n', 'St Georges Hall \r\n\r\n', 'Ages 14+ (under 16s must be accompanied by an adult)\r\n', 'From £15\r\nYouth pass £5\r\nSeniors (60+) = From £12\r\n\r\n', '4x4 legends Jamie Duggan, DJ Q, and TS7 join arranger Katie Chatburn and the orchestra of opera north to celebrate the sound of Bradford in this one night only spectacular, curated by Tanya Vital.\r\n\r\n\r\n', 'https://bradford2025.co.uk/event/bassline-symphony/\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/08/1019_Bassline-Symphony-Artists-DJ-Q_%C2%A9Max-Lee-1600x1067.jpg \r\n'),
(1014, 'Hope/Act\r\n\r\n', '31st April – 31st December 2025\r\n\r\n', 'People Powered Press\r\n\r\n', 'Bradford City Library \r\nKeighley Library \r\nNational Science and Media Museum \r\nMAPA\r\n\r\n', 'All ages\r\n\r\n', 'free\r\n', 'Bradford based company the People Powered Press bring their distinctive style and tools to make a set of murals that celebrate Bradford 2025. Using the largest letter printing press in the world this team of designers and artists produce largescale works that focus on lettering and community participation.\r\n\r\n', 'https://bradford2025.co.uk/event/hope-act/\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/03/People-Powered-Press-HOPE-ACT-printing-192C1050-web-600x400.jpg\r\n'),
(1015, 'Portrait of Mai \r\n\r\n\r\n', '22nd May – 17th August 2025\r\n \r\n', 'Sir Joshua Reynalds \r\n\r\n', 'Cartwright Hall Art Gallery \r\n\r\n', 'Artistic community\r\n\r\n\r\n\r\n', 'free', 'Touring for the first time since it was saved for the nation in 2023, Portrait of Mai will travel to the Bradford district as part of Bradford 2025.\r\n', 'https://bradford2025.co.uk/event/portrait-of-mai/\r\n\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/02/News-release_Journeys-with-Mai.jpg '),
(1016, 'Eggs collectives: Dark Nights \r\n\r\n\r\n', '20th June 2025\r\n\r\n \r\n\r\n', 'Eggs Collective \r\n\r\n\r\n', 'Loading Bay \r\n\r\n', 'Ages 18+\r\n\r\n', '£8\r\n\r\n', 'Ace comedic trio eggs collective – Sara Cocker, Léonie Higgins, and Lowri Evans trek over the Pennines to marks the shortest night of 2025 with a midsummer cabaret at Loading Bay.\r\n \r\n', 'https://bradford2025.co.uk/event/eggs-collectives-dark-nights/\r\n \r\n', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFRwS-Vj8ApZtqNSY3VXYlagd6Zz1Tv4g-KQ&s \r\n'),
(1017, 'Ice Age Art Show \r\n\r\n', '21st June – 14th September 2025\r\n\r\n', 'British museum \r\n\r\n', 'Cliffe Castle, Keighley\r\n\r\n', 'Family friendly – Suitable for all ages\r\n\r\n', 'free\r\n', 'Travel back in time at this British museum partnership exhibition and encounter works of art dating back thousands of years.\r\n\r\n', 'https://bradford2025.co.uk/event/ice-age-art-now/\r\n\r\n', 'https://eu-assets.simpleview-europe.com/visitbradford/imageresizer/?image=%2Fdmsimgs%2FLead_image_Mammoth_spear_thrower_2024_The_Trustees_of_the_British_Museum_1323564598.png&action=ProductDetailProFullWidth '),
(1018, 'John Grant: Plus Support\r\n\r\n', '7th October 2025\r\n', 'John Grant \r\n\r\n', 'St Georges Hall\r\n\r\n', 'Music lovers and LGBTQ+ Community \r\n\r\n', 'From £28\r\nYouth Pass £10\r\nSeniors (60+) from £25\r\n', 'The incomparable singer-songwriter performs his first headline show in the city – exclusively live for Bradford 2025.\r\n', 'https://bradford2025.co.uk/event/john-grant/\r\n', 'https://bradford2025.co.uk/wp-content/uploads/2025/03/John-Grant-4-600x400.jpg\r\n'),
(1019, 'Turner Prize \r\n \r\n', 'September 2025 – February 2026\r\n \r\n', 'The Tate Gallery', 'Cartwright Hall Art Gallery \r\n \r\n', 'Art enthusiasts \r\n \r\n', 'free\r\n', 'The annual Turner Prize showcases and celebrates the most exciting new developments in British art. In the year the Uk celebrates the 250th anniversary of the JMW Turners birth, the Turner Prize heads to Bradford.\r\n \r\n', 'https://bradford2025.co.uk/event/turner-prize/\r\n \r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/09/Turner-Prize.jpg'),
(1020, 'BBC Contains Strong Language \r\n\r\n', '18th September – 21st September 2025\r\n\r\n', 'BBC\r\n\r\n', 'Bradford Live \r\n\r\n', 'All ages \r\n \r\n', 'free\r\n', 'The UK’s Biggest poetry and performance festival for new writing is coming to Bradford for new writing for the first time.\r\n\r\n', 'https://bradford2025.co.uk/event/contains-strong-language/\r\n \r\n', 'https://bradford2025.co.uk/wp-content/uploads/2024/09/CSL-LEad-1600x1066.jpeg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
