public class WordBreak {
  /**
   * @param s: A string s
   * @param dict: A dictionary of words dict
   */
  public boolean wordBreak(String s, Set<String> dict) {
    if (s == null) {
      return false;
    }

    boolean[] f = new boolean[s.length() + 1];

    f[0] = true;

    for (int i = 1; i < s.length() + 1; i++) {
      for (int j = 0; j < i; j++) {
        if (f[j] && dict.contains(s.substring(j, i))) {
          f[i] = true;
          break;
        }
      }
    }

    return f[s.length()];
  }
}
