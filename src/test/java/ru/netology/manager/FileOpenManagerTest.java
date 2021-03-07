package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();
    Set<String> apps = new HashSet<>();
    List<String> extensions = new ArrayList<>();

    @Nested
    public class Empty {
        @Test
        void shouldRegisterApp() {
            manager.registerApp(".xls", "Excel");
            List<String> expected = List.of("Excel");
            assertEquals(expected, manager.getAllRegisteredApps());
        }

        @Test
        void shouldGetAppName() {
            assertNull(manager.getAppName(".mov"));
        }

        @Test
        void shouldRemoveAssociation() {
            manager.removeAssociation(".mkv");
            assertNull(manager.getAppName(".mkv"));
        }

        @Test
        void shouldGetAllRegisteredExtension() {
            List<String> expected = List.of();
            assertEquals(expected, manager.getAllRegisteredExtension());
        }

        @Test
        void shouldGetAllRegisteredApps() {
            List<String> expected = List.of();
            assertEquals(expected, manager.getAllRegisteredApps());
        }

    }

    @Nested
    public class Single {

        @BeforeEach
        void setUp() {
            manager.registerApp(".html", "Google Chrome");
        }

        @Test
        void shouldRegisterApp() {
            manager.registerApp(".xls", "Excel");
            List<String> expected = List.of("Excel", "Google Chrome");
            assertEquals(expected, manager.getAllRegisteredApps());
        }

        @Test
        void shouldGetAppName() {
            String expected = "Google Chrome";
            assertEquals(expected, manager.getAppName(".html"));
        }

        @Test
        void shouldRemoveAssociation() {
            manager.removeAssociation(".html");
            assertNull(manager.getAppName(".html"));
        }

        @Test
        void shouldGetAllRegisteredExtension() {
            List<String> expected = List.of(".html");
            assertEquals(expected, manager.getAllRegisteredExtension());
        }

        @Test
        void shouldGetAllRegisteredApps() {
            List<String> expected = List.of("Google Chrome");
            assertEquals(expected, manager.getAllRegisteredApps());
        }

    }

    @Nested
    public class MultipleItems {

        @BeforeEach
        void setUp() {
            manager.registerApp(".html", "Google Chrome");
            manager.registerApp(".MKV", "Potplayer");
            manager.registerApp(".mov", "Potplayer");
            manager.registerApp(".7z", "7-zip");
            manager.registerApp(".pdf", "Adobe Reader");
            manager.registerApp(".JPG", "Paint");
        }

        @Test
        void shouldRegisterApp() {
            manager.registerApp(".xls", "Excel");
            List<String> expected = List.of("7-zip", "Adobe Reader", "Excel", "Google Chrome", "Paint", "Potplayer");
            assertEquals(expected, manager.getAllRegisteredApps());
        }

        @Test
        void shouldGetAppName() {
            String expected = "Potplayer";
            assertEquals(expected, manager.getAppName(".mov"));
        }

        @Test
        void shouldRemoveAssociation() {
            manager.removeAssociation(".mkv");
            assertNull(manager.getAppName(".mkv"));
        }

        @Test
        void shouldGetAllRegisteredExtension() {
            List<String> expected = List.of(".7z", ".html", ".jpg", ".mkv", ".mov", ".pdf");
            assertEquals(expected, manager.getAllRegisteredExtension());
        }

        @Test
        void shouldGetAllRegisteredApps() {
            List<String> expected = List.of("7-zip", "Adobe Reader", "Google Chrome", "Paint", "Potplayer");
            assertEquals(expected, manager.getAllRegisteredApps());
        }
    }
}