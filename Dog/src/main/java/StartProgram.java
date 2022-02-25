

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.dog;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the dog's name: ");
			String name = in.nextLine();
			System.out.print("Enter the dog's breed: ");
			String breed = in.nextLine();
			System.out.print("Enter the dog's color: ");
			String color = in.nextLine();
			dog toAdd = new dog(breed, name, color);
			lih.insetItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the dog's name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the dog's breed to delete: ");
			String breed = in.nextLine();
			System.out.print("Enter the dog's color to delete: ");
			String color = in.nextLine();
			dog toDelete = new dog(breed, name, color);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by dog's name");
			System.out.println("2 : Search by dog's color");
			System.out.println("3 : Search by dog's breed");
			int searchBy = in.nextInt();
			in.nextLine();
			List<dog> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the Dog's name: ");
				String dogName = in.nextLine();
				foundItems = lih.searchForDogByName(dogName);
				
			}
			else if (searchBy == 2) {
				System.out.print("Enter the Dog's color: ");
				String color = in.nextLine();
				foundItems = lih.searchForDogByColor(color);
				
			}else {
				System.out.print("Enter the dog's breed: ");
				String breedName = in.nextLine();
				foundItems = lih.searchForDogByBreed(breedName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (dog l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				dog toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getColor());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Color");
				System.out.println("3 : Update Breed");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Color: ");
					String newColor = in.nextLine();
					toEdit.setColor(newColor);
				}
				else {
					System.out.print("New Breed: ");
					String newBreed = in.nextLine();
					toEdit.setBreed(newBreed);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome dog list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<dog>allItems = lih.showAllItems();
			for(dog singleItem: allItems) {
				System.out.println(singleItem.returnItemDetails());
			}
			

		}

	}