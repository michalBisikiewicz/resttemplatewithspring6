package org.example.fromfilesongreader;

import java.util.List;

// nazwa pliku songs musi się zgadzać z nazwą pliku z której pobieramy dane, a rodzaj zmiennej lista w tym wypadku odpowiada
// temu w jaki sposób wyglądają dane w tym pliku
record FileSongWrapper(List<FileSong> songs) {
}
