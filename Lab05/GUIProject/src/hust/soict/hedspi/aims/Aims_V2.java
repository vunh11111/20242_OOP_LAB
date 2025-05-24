package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.List;
import java.util.Scanner;

public class Aims_V2 {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Store store = new Store();
		// store.addMedia(...); // Thêm media vào store

		// Tạo một số DVD mặc định (như bạn đã làm)
		// ...

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			showMenu();
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				store.displayStore(); // Hiển thị tất cả media có trong Store
				int subChoice;
				do {
					storeMenu();
					subChoice = scanner.nextInt();
					scanner.nextLine(); // consume newline

					switch (subChoice) {
					case 1:
						// Xem chi tiết media theo title
						System.out.print("Enter title: ");
						String title = scanner.nextLine();
						Media media = store.searchByTitle(title); // cần cài đặt hàm này trong Store

						if (media != null) {
							System.out.println(media.toString()); // hoặc media.printDetails() nếu bạn viết riêng

							int detailChoice;
							do {
								mediaDetailsMenu();
								detailChoice = scanner.nextInt();
								scanner.nextLine(); // clear buffer

								switch (detailChoice) {
								case 1:
									anOrder.addMedia(media);
									break;
								case 2:
									if (media instanceof Playable) {
										try {
											((Playable) media).play();
										} catch (PlayerException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									} else {
										System.out.println("This media cannot be played.");
									}
									break;
								case 0:
									break;
								default:
									System.out.println("Invalid option!");
								}
							} while (detailChoice != 0);

						} else {
							System.out.println("Media not found.");
						}

					case 2:
						String title2 = scanner.nextLine();
						Media media2 = store.searchByTitle(title2);    
						if (media2 instanceof hust.soict.hedspi.aims.media.Playable playable) {
						        try {
									playable.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    } else {
						        System.out.println("This media cannot be played.");
						    }
					case 3:
						// Giả lập phát media nếu là CD hoặc DVD
						playMedia(scanner, store);
						break;
					case 4:
						anOrder.displayCart();
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice!");
					}
				} while (subChoice != 0);
				break;

			case 2:
				updateStore(scanner, store);
				break;
			case 3:
				Cart cart = new Cart();
				// See current cart
				cartMenu(scanner, cart);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		} while (choice != 0);

		scanner.close();
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
		System.out.println("Enter the title of the media to add to cart:");
		String title = scanner.nextLine();

		Media foundMedia = store.searchByTitle(title);
		if (foundMedia != null) {
			cart.addMedia(foundMedia);
			System.out.println("\"" + foundMedia.getTitle() + "\" has been added to your cart.");

			// Đếm số lượng DVD
			int dvdCount = 0;
			for (Media media : cart.getItemsOrdered()) {
				if (media instanceof DigitalVideoDisc) {
					dvdCount++;
				}
			}
			System.out.println("Number of DVDs in cart: " + dvdCount);
		} else {
			System.out.println("No media found with the title: \"" + title + "\"");
		}
	}

	public static void playMedia(Scanner scanner, Store store) {
		System.out.print("Enter the title of the media you want to play: ");
		String title = scanner.nextLine();

		Media media = store.searchByTitle(title);
		if (media == null) {
			System.out.println("Media not found!");
		} else if (media instanceof Playable) {
			try {
				((Playable) media).play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("This media cannot be played.");
		}
	}

	public static void updateStore(Scanner scanner, Store store) {
		System.out.println("Update Store Options:");
		System.out.println("1. Add a media to the store");
		System.out.println("2. Remove a media from the store");
		System.out.println("0. Back");
		System.out.print("Choose an option: ");

		int choice = Integer.parseInt(scanner.nextLine());
		switch (choice) {
		case 1 -> {
			System.out.println("Enter media type (DVD/CD/Book): ");
			String type = scanner.nextLine().trim();

			System.out.println("Enter title: ");
			String title = scanner.nextLine().trim();

			System.out.println("Enter category: ");
			String category = scanner.nextLine().trim();

			System.out.println("Enter cost: ");
			float cost = Float.parseFloat(scanner.nextLine());

			Media newMedia = null;

			if (type.equalsIgnoreCase("DVD")) {
				newMedia = new DigitalVideoDisc(title, category, cost);
			} else if (type.equalsIgnoreCase("CD")) {
				newMedia = new CompactDisc(title, category, cost);
			} else if (type.equalsIgnoreCase("Book")) {
				newMedia = new Book(title, category, cost);
			} else {
				System.out.println("Invalid media type.");
				return;
			}

			store.addMedia(newMedia);
			System.out.println("Media added to store.");
		}

		case 2 -> {
			System.out.print("Enter the title of media to remove: ");
			String title = scanner.nextLine().trim();
			Media media = store.searchByTitle(title);

			if (media != null) {
				store.removeMedia(media);
				System.out.println("Media removed.");
			} else {
				System.out.println("Media not found.");
			}
		}

		case 0 -> System.out.println("Returning to main menu...");

		default -> System.out.println("Invalid option.");
		}

	}

	public static void cartMenu(Scanner scanner, Cart cart) {
	    while (true) {
	        System.out.println("Options: ");
	        System.out.println("--------------------------------");
	        System.out.println("1. Filter media in cart");
	        System.out.println("2. Sort media in cart");
	        System.out.println("3. Remove media from cart");
	        System.out.println("4. Play a media");
	        System.out.println("5. Place order");
	        System.out.println("0. Back");
	        System.out.println("--------------------------------");
	        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
	
	        int choice = Integer.parseInt(scanner.nextLine());
	
	        switch (choice) {
	            case 1 -> filterMediaInCart(scanner, cart);
	            case 2 -> sortMediaInCart(scanner, cart);
	            case 3 -> removeMediaFromCart(scanner, cart);
	            case 4 -> playMedia(scanner, cart);
	            case 5 -> {
	                cart.placeOrder();  // giả sử bạn có hàm này
	                return;
	            }
	            case 0 -> {
	                return;
	            }
	            default -> System.out.println("Invalid option. Try again.");
	        }
	    }
	}
	public static void filterMediaInCart(Scanner scanner, Cart cart) {
	    System.out.println("Filter by: 1. ID | 2. Title");
	    int option = Integer.parseInt(scanner.nextLine());

	    if (option == 1) {
	        System.out.print("Enter ID: ");
	        int id = Integer.parseInt(scanner.nextLine());
	        Media media = cart.searchById(id);
	        if (media != null) {
	            System.out.println("Found: " + media.toString());
	        } else {
	            System.out.println("No media found with that ID.");
	        }
	    } else if (option == 2) {
	        System.out.print("Enter Title: ");
	        String title = scanner.nextLine().trim();
	        List<Media> mediaList = cart.searchByTitle(title);
	        if (!mediaList.isEmpty()) {
	            System.out.println("Found:");
	            for (Media media : mediaList) {
	                System.out.println(media.toString());
	            }
	        } else {
	            System.out.println("No media found with that title.");
	        }
	    } else {
	        System.out.println("Invalid filter option.");
	    }
	}

	public static void sortMediaInCart(Scanner scanner, Cart cart) {
	    System.out.println("Sort by: 1. Title | 2. Cost");
	    int option = Integer.parseInt(scanner.nextLine());

	    if (option == 1) {
	        cart.sortByTitle();
	    } else if (option == 2) {
	        cart.sortByCost();
	    } else {
	        System.out.println("Invalid sort option.");
	    }

	    System.out.println("Sorted cart content:");
	    cart.displayCart();
	}
	public static void removeMediaFromCart(Scanner scanner, Cart cart) {
	    System.out.println("Remove by: 1. ID | 2. Title");
	    int option = Integer.parseInt(scanner.nextLine());

	    if (option == 1) {
	        System.out.print("Enter ID of the media to remove: ");
	        int id = Integer.parseInt(scanner.nextLine());
	        Media media = cart.searchById(id);
	        if (media != null) {
	            cart.removeMedia(media);
	        } else {
	            System.out.println("No media found with that ID.");
	        }
	    } else if (option == 2) {
	        System.out.print("Enter Title of the media to remove: ");
	        String title = scanner.nextLine().trim();
	        List<Media> mediaList = cart.searchByTitle(title);
	        if (!mediaList.isEmpty()) {
	            System.out.println("Choose which one to remove (enter index starting from 1): ");
	            for (int i = 0; i < mediaList.size(); i++) {
	                System.out.println((i + 1) + ". " + mediaList.get(i).toString());
	            }
	            int choice = Integer.parseInt(scanner.nextLine());
	            if (choice >= 1 && choice <= mediaList.size()) {
	                cart.removeMedia(mediaList.get(choice - 1));
	            } else {
	                System.out.println("Invalid choice.");
	            }
	        } else {
	            System.out.println("No media found with that title.");
	        }
	    } else {
	        System.out.println("Invalid remove option.");
	    }
	}
	public static void playMedia(Scanner scanner, Cart cart) {
	    System.out.print("Enter the title of the media you want to play: ");
	    String title = scanner.nextLine().trim();

	    List<Media> mediaList = cart.searchByTitle(title);
	    if (mediaList.isEmpty()) {
	        System.out.println("No media found with that title.");
	        return;
	    }

	    System.out.println("Found media:");
	    for (int i = 0; i < mediaList.size(); i++) {
	        System.out.println((i + 1) + ". " + mediaList.get(i).toString());
	    }

	    System.out.print("Enter the number of the media to play: ");
	    int choice = Integer.parseInt(scanner.nextLine());

	    if (choice < 1 || choice > mediaList.size()) {
	        System.out.println("Invalid choice.");
	        return;
	    }

	    Media selectedMedia = mediaList.get(choice - 1);
	    if (selectedMedia instanceof Playable playableMedia) {
	        try {
				playableMedia.play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("This media cannot be played.");
	    }
	}

}
