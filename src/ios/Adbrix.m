//
//  Adbrix.m
//  DreamDNA
//
//  Created by mscbrain on 2016. 10. 6..
//
//
#import "Adbrix.h"
#import <Cordova/CDVPlugin.h>
#import <AdBrix/AdBrix.h>

@implementation Adbrix

-(void) retention :(CDVInvokedUrlCommand*)command
{
    NSMutableDictionary *options = [[command.arguments lastObject] mutableCopy];
    NSString* menuName = options[@"menuName"];
    NSLog(@"menuName============!!==%@", menuName);
    
}

@end
