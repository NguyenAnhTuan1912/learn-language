class ConsumeArguments {
  public static void main(String[] args) {
    System.out.println("Receive these arguments");
    for (String arg : args) {
      System.out.print("Argument:");
      System.out.println(arg);
    }
  }
}